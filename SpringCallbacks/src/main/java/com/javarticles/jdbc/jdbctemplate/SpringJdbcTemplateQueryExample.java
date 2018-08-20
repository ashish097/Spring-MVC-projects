package com.javarticles.jdbc.jdbctemplate;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class SpringJdbcTemplateQueryExample {
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) throws SQLException {
        @SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        SpringJdbcTemplateQueryExample stmtQueryExample = (SpringJdbcTemplateQueryExample) context
                .getBean("springJtExample");
        stmtQueryExample.queryEmployee();
    }

    public void queryEmployee() throws SQLException {
        String sql = "SELECT * FROM ARTICLES WHERE CATEGORY=? AND AUTHOR=?";
        String sqlWithValues = "SELECT * FROM ARTICLES WHERE CATEGORY='spring' AND AUTHOR='Joe'";
        Object[] values = new Object[] { "spring", "Joe" };

        // PreparedStatementCallback example
        System.out.println("PreparedStatementCallback example");
        List<Article> aList = getJdbcTemplate().execute(sqlWithValues,
                new ArticleListPreparedStatement());
        System.out.println(aList);

        // ResultSetExtractor Example
        System.out.println("ResultSetExtractor example");
        aList = getJdbcTemplate()
                .query(sql, values, new ArticleListResultSet());
        System.out.println(aList);

        // RowCallbackHandler Example
        System.out.println("RowCallbackHandler example");
        ArticleRowCallbackHandler rowHandler = new ArticleRowCallbackHandler();
        getJdbcTemplate().query(sql, values, rowHandler);
        System.out.println(rowHandler.getArticleList());

        // RowMapper Example
        System.out.println("RowMapper example");
        aList = getJdbcTemplate().query(sql, values, new ArticleRowMapper());
        System.out.println(rowHandler.getArticleList());
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
