package com.example.demo;


import com.example.demo.DatabaseConnectionDAO.DatabaseInteraction;
import com.example.demo.models.datainput.StudentDataInput;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		//SpringApplication.run(DemoApplication.class, args);

		ApplicationContext context = new ClassPathXmlApplicationContext("BeansConfigaration.xml");

		DatabaseInteraction databaseInteraction = context.getBean("DatabaseInteraction", DatabaseInteraction.class);
		StudentDataInput studentDataInput = context.getBean("studentDataInput", StudentDataInput.class);


		//databaseInteraction.insertData();

		//databaseInteraction.batchInsertion(studentDataInput.studentModelArrayList());

		//databaseInteraction.getStudentData();

		//databaseInteraction.printStudentModel();

		//databaseInteraction.printStudentModel();

		databaseInteraction.getStudentById("C026-01-0900/2021");

	}
}
