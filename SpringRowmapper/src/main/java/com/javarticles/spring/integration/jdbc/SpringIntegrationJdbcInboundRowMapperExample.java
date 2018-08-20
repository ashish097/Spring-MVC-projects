package com.javarticles.spring.integration.jdbc;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIntegrationJdbcInboundRowMapperExample {

    public static void main(String[] args) throws InterruptedException, IOException, SQLException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "jdbcInboundApplicationContext.xml");
        Thread.sleep(1000);
        context.close();
    }
    
}
