package com.itwen.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLDataException;
import java.sql.SQLException;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/10/16 21:09
 * 文件描述：
 */
public class DataSourceTest {
    @Test
    public void testDataSource() throws SQLException {
        ApplicationContext ioc =  new ClassPathXmlApplicationContext("spring-datasource.xml");
        DruidDataSource datasource = ioc.getBean(DruidDataSource.class);
        DruidPooledConnection connection = datasource.getConnection();

        System.out.println(connection);
    }
}
