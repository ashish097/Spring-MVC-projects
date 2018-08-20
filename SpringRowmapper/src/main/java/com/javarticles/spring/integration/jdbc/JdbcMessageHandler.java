package com.javarticles.spring.integration.jdbc;

import java.util.List;

public class JdbcMessageHandler {
    public void handleMessage(List<Article> articleList) {
        System.out.println("In JdbcMessageHandler:" + articleList);
    }
}
