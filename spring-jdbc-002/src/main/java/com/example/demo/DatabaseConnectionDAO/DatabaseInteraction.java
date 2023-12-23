package com.example.demo.DatabaseConnectionDAO;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


public class DatabaseInteration {


    JdbcTemplate jdbcTemplate;


    public void init()
    {
        System.out.println("Hello there....");
    }
}
