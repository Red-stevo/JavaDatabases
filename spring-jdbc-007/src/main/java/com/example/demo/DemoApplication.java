package com.example.demo;


import com.example.demo.Configaration.DatabaseConfig;
import com.example.demo.Models.StudentAddressUpdateModel;
import com.example.demo.Repository.StudentBatchOperationsRepository;
import com.example.demo.Repository.StudentRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws Exception {

        ApplicationContext context = new
				AnnotationConfigApplicationContext(DatabaseConfig.class);

		StudentRepository studentRepository = context.getBean("studentRepository",
				StudentRepository.class);

		StudentBatchOperationsRepository studentBatchOperationsRepository
				= context.getBean("studentBatchOperationsRepository",
				StudentBatchOperationsRepository.class);

	/*	studentRepository.deleteStudentByRegNo("C026-01-0931/2019");

		studentRepository.deleteStudentByNames("James", "Mark");

		studentRepository.findStudentByName("Stephen");

		studentRepository.addressGroupedRecord();

		//studentRepository.tableCleanUp();
*/
		List<StudentAddressUpdateModel> studentAddressUpdateModelList
				= new ArrayList<>();

		StudentAddressUpdateModel studentAddressUpdateModel = new StudentAddressUpdateModel();
		studentAddressUpdateModel.setStudentAddress("NewYork1");
		studentAddressUpdateModel.setStudentRegNo(6789);

		StudentAddressUpdateModel studentAddressUpdateModel1 = new StudentAddressUpdateModel();
		studentAddressUpdateModel1.setStudentAddress("Toronto1");
		studentAddressUpdateModel1.setStudentRegNo(1234);

		StudentAddressUpdateModel studentAddressUpdateModel2 = new StudentAddressUpdateModel();
		studentAddressUpdateModel2.setStudentAddress("South Africawertyunukv " +
				"yibciyzsvlyyyyyyyyyyyyyyyyyyyyyyyy hfawehbweiugh0'c " +
				"nzbiybcYzbgydhcuwrhbeg vb9hece r8eh9yvkcjerhocreb" +
				"vxke hr79gfbvdfh8;hfwfijcihvffbuivnflcnouecdlnjdcsjifonfdiofnejfjh" +
				"fdjfDSfjadfdjfjiffufuoffibfiydfcevilbeibyea");
		studentAddressUpdateModel2.setStudentRegNo(7689);


		studentAddressUpdateModelList.add(studentAddressUpdateModel);
		studentAddressUpdateModelList.add(studentAddressUpdateModel1);
		studentAddressUpdateModelList.add(studentAddressUpdateModel2);

		int rowsAffected = studentBatchOperationsRepository.updateStudentAddress
				(studentAddressUpdateModelList);

		System.out.println(rowsAffected+" Rows Affected...>>>");

	}

}
