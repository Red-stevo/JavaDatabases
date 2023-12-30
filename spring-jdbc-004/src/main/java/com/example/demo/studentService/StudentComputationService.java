package com.example.demo.studentService;

import com.example.demo.Models.StudentModel;
import com.example.demo.StudentRepository.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentComputationService {
    public String batchInsertion(/*
                                  from the front end or the user UI we should get the list to be updated
                                  In this project I will insert  the values in the service layer.*/)
    {

        List<StudentModel> studentModelList = new ArrayList<>();

        StudentModel studentModel1 = new StudentModel();

        studentModel1.setStudentName("Stephen Muiru");

        studentModel1.setStudentEmail("Stephen.muiru22@students.dkut.ac.ke");

        studentModel1.setStudentPassword("Aa37333681!");

        studentModelList.add(studentModel1);


        StudentModel studentModel2 = new StudentModel();

        studentModel2.setStudentName("Stephen Muiru");

        studentModel2.setStudentEmail("Stepmuish@gmail.com");

        studentModel2.setStudentPassword("AA37333681!");

        studentModelList.add(studentModel2);

        StudentModel studentModel3 = new StudentModel();

        studentModel3.setStudentName("Stephen Muiru");

        studentModel3.setStudentEmail("Stevenmuish@gmail.com");

        studentModel3.setStudentPassword("aa37333681!");

        studentModelList.add(studentModel3);

        StudentDao studentDao1 = new StudentDao();


        studentDao1.batchStudentsInsert(studentModelList);

        return null;
    }

}
