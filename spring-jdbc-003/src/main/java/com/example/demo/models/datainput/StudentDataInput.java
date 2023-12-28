package com.example.demo.models.datainput;
import com.example.demo.models.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Scanner;

@Component
public class StudentDataInput {

    @Autowired
    StudentModel studentModel;

    Scanner scanner;

    public StudentModel hardCodedDataInput()
    {


        scanner = new Scanner(System.in);

        System.out.println("Enter fname : ");
        studentModel.setfName(scanner.next());
        System.out.println("Enter sname : ");
        studentModel.setsName(scanner.next());
        System.out.println("Enter regno : ");
        studentModel.setRegno(scanner.next());

        return studentModel;
    }

    public ArrayList<StudentModel> studentModelArrayList()
    {
        ArrayList<StudentModel> studentModelArrayList = new ArrayList<>();

        for(int i=0; i<3;i++)
        {
            StudentModel studentModel1 = hardCodedDataInput();
            studentModelArrayList.add(studentModel1);
        }
        return studentModelArrayList;

    }
}
