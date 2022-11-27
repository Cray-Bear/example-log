package com.fty1.example.log.expr;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.infra.datanode.DataNode;
import org.apache.shardingsphere.infra.util.expr.InlineExpressionParser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class InlineExprTest {

    @Test
    public void inlineTest() {
        List<String> actualDataSources = new InlineExpressionParser("ds_${0..2}.t_user_${0..7}").splitAndEvaluate();
        log.info("Res:{}", JSON.toJSONString(actualDataSources));
        System.out.println(JSON.toJSONString(actualDataSources));


        List<DataNode> dataNodes = new ArrayList<>();
        for (String each : actualDataSources) {
            log.info("Each text:{}", each);
            log.info("Each DataNode:{}", new DataNode(each));
            dataNodes.add(new DataNode(each));
        }
        System.out.println(JSON.toJSONString(dataNodes));
    }
}
