package com.example.demo.Models;


import org.springframework.stereotype.Component;

@Component
public class StudentModel {

    private String StudentName;

    private String StudentPassword;

    private String StudentEmail;


    public String StudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String StudentPassword() {
        return StudentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        StudentPassword = studentPassword;
    }

    public String StudentEmail() {
        return StudentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        StudentEmail = studentEmail;
    }

    public String toString()
    {
        return "StudentName " + StudentName + " StudentEmail "+ StudentEmail + " StudentPassword " +StudentPassword;
    }
}
