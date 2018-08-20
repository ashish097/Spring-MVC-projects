package com.javarticles.jdbc.jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowCallbackHandler;

public class ArticleRowCallbackHandler implements RowCallbackHandler {
    private List<Article> aList;
    
    public ArticleRowCallbackHandler() {
        aList = new ArrayList<Article>();
    }

    public void processRow(ResultSet rs) throws SQLException {
        aList.add(QueryUtils.extractArticleFromRs(rs));
    }
    
    public List<Article> getArticleList() {
        return aList;
    }        
}