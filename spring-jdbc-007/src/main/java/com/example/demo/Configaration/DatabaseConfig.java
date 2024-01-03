package com.example.demo.Configaration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.example.demo")
public class DatabaseConfig {

    @Bean
    public DataSource data() {
        String url = "jdbc:mariadb://localhost:3306/SpringJDBC";

        String userName = "steve";

        String password = "sijui!";

        DataSource dataSource;

        dataSource = new DriverManagerDataSource(url, userName, password);

        {
            System.out.println("""
                    Configured the dataSource...>>""");
        }

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate()
    {
        DataSource dataSource = data();

        JdbcTemplate jdbcTemplate;

        jdbcTemplate = new JdbcTemplate(dataSource);

        return jdbcTemplate;
    }
}
