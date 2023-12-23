package com.example.demo.rowData;

import com.example.demo.Models.StudentModel;

public class StudentDataGetter {
    private StudentModel studentModel;

    public StudentModel hardCodeStudentData()
    {
        studentModel = new StudentModel();

        studentModel.setfName("Bob");
        studentModel.setsName("Mirowe");
        studentModel.setRegno("C026-01-0922/2022");

        return studentModel;
    }

}
