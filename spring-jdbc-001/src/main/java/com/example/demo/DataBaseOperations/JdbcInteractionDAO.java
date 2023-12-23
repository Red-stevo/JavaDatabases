package com.example.demo.DataBaseOperations;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class JdbcInteraction implements JdbcComputationDAO{
    JdbcTemplate jdbcTemplate = new JdbcTemplate(connection());

    @Override
    public DataSource connection() {
        String url = "jdbc:mariadb://127.0.0.1:3306/SpringJDBC?useSSL=true";
        String userName = "steve";
        String password = "sijui!";

        DataSource dataSource = new DriverManagerDataSource(url,userName,password);
        System.out.println("Connected....");
        return dataSource;
    }

    @Override
    public void insertData()
    {
        String sql ="INSERT INTO studentInfo VALUES (?,?,?);";

        Object[] values = {};
        jdbcTemplate.update(sql);
    }

    @Override
    public void disConnect() {

    }
}
