package com.example.demo.Models;


import org.springframework.stereotype.Component;

@Component
public class StudentModel {

    private String StudentName;

    private String StudentPassword;

    private String StudentEmail;

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getStudentPassword() {
        return StudentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        StudentPassword = studentPassword;
    }

    public String getStudentEmail() {
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
