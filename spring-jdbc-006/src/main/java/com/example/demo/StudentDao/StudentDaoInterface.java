package com.example.demo.StudentDao;

import com.example.demo.Models.StudentModel;

import java.util.List;
import java.util.Map;

public interface StudentDaoInterface {

    public String deleteStudentById(String studentId);

    public String deleteStudentByFNameOrSName(String fName, String sName);

    List<Map<String,Object>> selectStudentByName(String studentName);

    Map<String, List<String>> selectAddressGroupedData();
}
