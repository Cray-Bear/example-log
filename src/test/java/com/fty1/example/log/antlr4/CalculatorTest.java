package com.fty1.example.log.antlr4;

import com.example.antlr4.gen.CalculatorBaseVisitor;
import com.example.antlr4.gen.CalculatorLexer;
import com.example.antlr4.gen.CalculatorParser;
import com.example.antlr4.gen.CalculatorVisitor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

@Slf4j
public class CalculatorTest {


    @Test
    public void countTest() {
        CharStream input = CharStreams.fromString("12*2+12");
        CalculatorLexer lexer = new CalculatorLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CalculatorParser parser = new CalculatorParser(tokens);
        CalculatorParser.ExprContext tree = parser.expr();
        CalculatorVisitor tv = new OpVisitor();
        tv.visit(tree);
    }

    static class OpVisitor extends CalculatorBaseVisitor<Void> {
        @Override
        public Void visitAdd(CalculatorParser.AddContext ctx) {
            log.info("CalculatorParser.AddContext Mul");
            log.info("arg[0]: " + ctx.expr(0).getText());
            log.info("arg[1]: " + ctx.expr(1).getText());
            return super.visitAdd(ctx);
        }


        @Override
        public Void visitMul(CalculatorParser.MulContext ctx) {
            log.info("CalculatorParser.MulContext Mul");
            log.info("arg[0]: " + ctx.expr(0).getText());
            log.info("arg[1]: " + ctx.expr(1).getText());
            return super.visitMul(ctx);
        }
    }
}
