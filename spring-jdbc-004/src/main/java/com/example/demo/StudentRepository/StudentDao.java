package com.example.demo.StudentRepository;

import com.example.demo.Models.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("studentDao")
public class StudentDao {

   private JdbcTemplate jdbcTemplate;

   @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<StudentModel> getStudents()
    {

        return null;
    }

    public  StudentModel getStudentByEmail(String studentEmail)
    {

        return null;
    }

    public String insertStudent(StudentModel studentModel)
    {

        return null;
    }

    public String batchStudentsInsert(Object[] studentModels)
    {


        String insertSql =  "INSERT INTO StudentLogin VALUES (?,?,?)";

        int numberOfRowAffected = jdbcTemplate.batchUpdate(insertSql,);

        return  null;
    }


}
