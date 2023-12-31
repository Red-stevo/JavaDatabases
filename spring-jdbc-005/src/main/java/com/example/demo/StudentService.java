package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentService {

    StudentDao studentDao;

    @Autowired
    public void setStudentDao(StudentDao studentDao)
    {
        this.studentDao = studentDao;
    }

    public String batchInsertionData(/*
                                  from the front end or the user UI we should get the list to be updated
                                  In this project I will insert  the values in the service layer.*/) {

        {
            System.out.println("Configuring the dataModel List...");
        }

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

        String rep;
        rep = studentDao.batchStudentsInsert(studentModelList);

        return rep;
    }


    public String studentData()
    {
        StudentModel studentModel1 = new StudentModel();

        studentModel1.setStudentName("Joseph Maina");

        studentModel1.setStudentEmail("joseph.maina22@students.dkut.ac.ke");

        studentModel1.setStudentPassword("37681!");

        {
            System.out.println("Configured the studentModel data...");
        }

        String res;

        res = studentDao.insertStudent(studentModel1);

        return res;
    }

    public void getAllStudents()
    {
        List<StudentModel> studentModelList = studentDao.getStudentsData();

        for(StudentModel studentModel : studentModelList)
        {
            System.out.println(studentModel);
        }
    }

    public void findStudentByEmail(String StudentEmail)
    {
        StudentModel studentModel = studentDao.getStudentData(StudentEmail);

        System.out.println(studentModel);
    }

    public String deleteStudent(String StudentEmail)
    {
        String deletionStatus;
        deletionStatus = studentDao.deleteStudent(StudentEmail);

        return deletionStatus;
    }

}
