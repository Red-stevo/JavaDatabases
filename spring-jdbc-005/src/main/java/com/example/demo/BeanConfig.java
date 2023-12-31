package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.example.demo")
public class BeanConfig {
    @Bean
    public DataSource data()
    {
        DataSource data = new DriverManagerDataSource("jdbc:mariadb://127.0.0.1/SpringJDBC", "steve", "sijui!");

        System.out.println("Configured the data source");

        return data;
    }

    @Bean
    public JdbcTemplate jdbcTemplate()
    {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(data());

        System.out.println("Configure the jdbcTemplate.....\nConnection created...");

        return jdbcTemplate;
    }
}
