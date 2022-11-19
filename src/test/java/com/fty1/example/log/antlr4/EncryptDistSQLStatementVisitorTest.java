package com.fty1.example.log.antlr4;

import com.alibaba.fastjson.JSON;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.apache.shardingsphere.distsql.parser.core.featured.FeaturedDistSQLParseASTNode;
import org.apache.shardingsphere.distsql.parser.core.featured.FeaturedDistSQLStatementParserFacadeFactory;
import org.apache.shardingsphere.encrypt.distsql.parser.facade.EncryptDistSQLStatementParserFacade;
import org.apache.shardingsphere.sql.parser.api.visitor.SQLVisitor;
import org.apache.shardingsphere.sql.parser.core.ParseASTNode;
import org.apache.shardingsphere.sql.parser.core.SQLParserFactory;
import org.apache.shardingsphere.sql.parser.exception.SQLParsingException;
import org.apache.shardingsphere.sql.parser.sql.common.statement.SQLStatement;
import org.junit.jupiter.api.Test;


@Slf4j
public class EncryptDistSQLStatementVisitorTest {


    // 需要解析的规则文件
    public static final String TEXT = "CREATE \n" + "ENCRYPT RULE \n" + "t_user (\n" + "COLUMNS(\n" + "(NAME=real_name,PLAIN=real_name,CIPHER=real_name_cipher,TYPE(NAME='AES',\n" + "PROPERTIES('aes-key-value'='nuKl!@#ze'))),\n" + "(NAME=id_no,PLAIN=id_no,CIPHER=id_no_cipher,TYPE(NAME='AES',\n" + "PROPERTIES('aes-key-value'='nuKl!@#ze')))\n" + "),QUERY_WITH_CIPHER_COLUMN=true)" + "";


    @Test
    public void sqlParserEngine() {
        SQLStatement res = parse(TEXT);
        log.info("SQLStatement: {}", JSON.toJSONString(res, true));
    }


    /**
     * Parse SQL.
     *
     * @param sql SQL to be parsed
     * @return SQL statement
     */
    public SQLStatement parse(final String sql) {
        FeaturedDistSQLParseASTNode featuredDistSQLParseASTNode = parseToASTNode(sql);
        return getSQLStatement(sql, featuredDistSQLParseASTNode.getFeatureType(), featuredDistSQLParseASTNode.getParseASTNode());
    }

    private FeaturedDistSQLParseASTNode parseToASTNode(final String sql) {
        try {
            EncryptDistSQLStatementParserFacade each = new EncryptDistSQLStatementParserFacade();
            ParseASTNode parseASTNode = (ParseASTNode) SQLParserFactory.newInstance(sql, each.getLexerClass(), each.getParserClass()).parse();
            return new FeaturedDistSQLParseASTNode(each.getType(), parseASTNode);
        } catch (final ParseCancellationException | SQLParsingException ignored) {
        }
        throw new SQLParsingException(sql);
    }

    @SneakyThrows(ReflectiveOperationException.class)
    @SuppressWarnings("rawtypes")
    private SQLStatement getSQLStatement(final String sql, final String featureType, final ParseASTNode parseASTNode) {
        SQLVisitor visitor = FeaturedDistSQLStatementParserFacadeFactory.getInstance(featureType).getVisitorClass().getDeclaredConstructor().newInstance();
        if (parseASTNode.getRootNode() instanceof ErrorNode) {
            throw new SQLParsingException(sql);
        }
        return (SQLStatement) ((ParseTreeVisitor) visitor).visit(parseASTNode.getRootNode());
    }

}
