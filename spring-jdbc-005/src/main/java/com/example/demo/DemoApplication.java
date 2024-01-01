package com.example.demo;



import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

		StudentService studentService = context.getBean("studentService", StudentService.class);

		//System.out.println(studentService.batchInsertionData());

		System.out.println(studentService.studentData());

		studentService.getAllStudents();

		studentService.findStudentByEmail("Stevenmuish@gmail.com");

		//studentService.deleteStudent("joseph.maina22@students.dkut.ac.ke");

	//	studentDao.cleanUpDataBase();


	}

}
