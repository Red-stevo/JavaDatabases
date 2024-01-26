package com.example.demo.Repository;

import com.example.demo.Models.DemoModel;
import com.example.demo.Models.StudentModel;
import com.example.demo.StudentDao.StudentManipulationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public class StudentRepository {

    StudentManipulationDao studentManipulationDao;

    StudentModel studentModel;



    @Autowired
    public void setStudentManipulationDao(StudentManipulationDao studentManipulationDao) {
        this.studentManipulationDao = studentManipulationDao;
    }

    @Autowired
    public void setStudentModel(StudentModel studentModel) {
        this.studentModel = studentModel;
    }


    public void deleteStudentByRegNo(String studentRegNo)
    {
        {
            System.out.println("""
                    deleteStudentByRegNo(String studentRegNo)
                    configuration student deletion...>>>""");
        }

        studentManipulationDao.deleteStudentById(studentRegNo);
    }

    public void deleteStudentByNames(String fName, String sName)
    {
        {
            System.out.println("""
                    deleteStudentByNames(String fName, String sName)
                    configuration student deletion...>>>""");
        }

        String i = studentManipulationDao.deleteStudentByFNameOrSName(fName, sName);

        System.out.println(i+" Rows Affected.");
    }

    public void tableCleanUp()
    {
        {
            System.out.println("""
                    
                    processing table clean up....>>>""");
        }

        studentManipulationDao.cleanUpTable();
    }

    public void findStudentByName(String studentName) {

        {
            System.out.println("""
                    
                    findStudentByName(String studentName)
                    Processing students from the database...>>>>>
                    """);
        }

        List<Map<String, Object>> mapList = studentManipulationDao.selectStudentByName(studentName);

        for(Map<String , Object> objectMap : mapList)
        {
            System.out.println(objectMap);
        }
    }

    public void addressGroupedRecord() {

        DemoModel demoModel = new DemoModel();




       demoModel.setName("Stephen Muiru");

        System.out.println(demoModel);

       /* System.out.println(demoModel);
        Map<String, List<String>> addressGroupedMap;

        addressGroupedMap = studentManipulationDao.selectAddressGroupedData();*/




    }
}
