package com.example.demo;


import com.example.demo.studentService.StudentComputationService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		//SpringApplication.run(DemoApplication.class, args);

		//ApplicationContext context = new AnnotationConfigApplicationContext(ConnectionConfig.class);
		ApplicationContext context = new ClassPathXmlApplicationContext("BeanConfig.xml");


		StudentComputationService studentComputationService = context.getBean("studentComputationService", StudentComputationService.class);

		studentComputationService.batchInsertion();
	
	}
}
