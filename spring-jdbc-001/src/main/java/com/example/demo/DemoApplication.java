package com.example.demo;

import com.example.demo.DataBaseOperations.JdbcComputationDAO;
import com.example.demo.DataBaseOperations.JdbcInteractionDAO;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		//SpringApplication.run(DemoApplication.class, args);

		JdbcComputationDAO jdbcComputationDAO = new JdbcInteractionDAO();

		jdbcComputationDAO.insertData();


	}

}
