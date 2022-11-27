package com.fty1.example.log.antlr4;

import com.alibaba.fastjson.JSON;
import org.apache.shardingsphere.driver.jdbc.core.datasource.ShardingSphereDataSource;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

@SpringBootTest
class DataSourceTest {


    @Autowired
    private ShardingSphereDataSource shardingDataSource;


    @Test
    public void encryptDistSQL() {
        String text = "SHOW SHARDING ALGORITHMS";
        try (Connection con = shardingDataSource.getConnection();
             Statement  stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(text);
            System.out.println(JSON.toJSONString(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
