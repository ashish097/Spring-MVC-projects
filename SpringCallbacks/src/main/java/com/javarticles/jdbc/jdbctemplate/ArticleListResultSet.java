package com.javarticles.jdbc.jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class ArticleListResultSet implements ResultSetExtractor<List<Article>> {
    public List<Article> extractData(ResultSet rs) throws SQLException,
            DataAccessException {
        return QueryUtils.extractArticleListFromRs(rs);
    }       
}