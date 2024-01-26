package com.example.demo;


import com.example.demo.Configaration.DatabaseConfig;
import com.example.demo.Repository.StudentRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws Exception {

        ApplicationContext context = new AnnotationConfigApplicationContext(DatabaseConfig.class);

		StudentRepository studentRepository = context.getBean(
				"studentRepository", StudentRepository.class);





	}

}
