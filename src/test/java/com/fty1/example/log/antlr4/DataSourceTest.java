package com.fty1.example.log.antlr4;

import org.apache.shardingsphere.driver.jdbc.core.datasource.ShardingSphereDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@SpringBootTest
class DataSourceTest {


    @Autowired
    private DataSource shardingDataSource;


    @Test
    public void encryptDistSQL() {
        try (Connection con = shardingDataSource.getConnection();
             Statement stmt = con.createStatement()) {
            boolean rs = stmt.execute("select * from t_user limit 1");

            if(shardingDataSource instanceof ShardingSphereDataSource) {
                shardingDataSource.
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
