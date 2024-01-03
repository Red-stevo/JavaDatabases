package com.example.demo.Models;

import org.springframework.stereotype.Component;

@Component
public class StudentAddressUpdateModel {

    private String studentAddress;

    private int studentRegNo;

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public int getStudentRegNo() {
        return studentRegNo;
    }

    public void setStudentRegNo(int studentRegNo) {
        this.studentRegNo = studentRegNo;
    }
}
