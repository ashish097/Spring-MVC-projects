package com.javarticles.jdbc.jdbctemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;

public class ArticleListPreparedStatement implements PreparedStatementCallback<List<Article>> {
    public List<Article> doInPreparedStatement(PreparedStatement ps)
            throws SQLException, DataAccessException {
        return QueryUtils.extractArticleListFromRs(ps.executeQuery());            
    }
}