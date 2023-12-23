package com.example.demo.models.datainput;

import com.example.demo.models.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentDataInput {

    @Autowired
    StudentModel studentModel;

    public StudentModel hardCodedDataInput()
    {
        studentModel.setfName("Faith");
        studentModel.setsName("Chebet");
        studentModel.setRegno("C026-01-0965/2022");

        return studentModel;
    }
}
