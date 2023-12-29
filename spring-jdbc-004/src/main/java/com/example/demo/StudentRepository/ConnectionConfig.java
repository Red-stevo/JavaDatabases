package com.example.demo.StudentRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

@Configuration
@ComponentScan("com.example.demo")
public class ConnectionConfig {

    @Bean
    public JdbcTemplate jdbcTemplate()
    {

        System.out.println("Setting up the jdbc Connection .....\n");
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public DataSource dataSource()
    {
        return new DriverManagerDataSource("jdbc:mariadb://127.0.0.1:3306/SpringJDBC", "steve", "sijui!");
    }

}
