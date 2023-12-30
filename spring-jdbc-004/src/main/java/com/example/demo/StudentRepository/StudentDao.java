package com.example.demo.StudentRepository;

import com.example.demo.Models.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository("studentDao")
public class StudentDao {
    JdbcTemplate jdbcTemplate;
    public void method()
    {
        DataSource dataSource = new DriverManagerDataSource("jdbc:mariadb://127.0.0.1:3306/SpringJDBC",
                "steve", "sijui!");

        jdbcTemplate = new JdbcTemplate(dataSource);
    }



    public String batchStudentsInsert(List<StudentModel> studentModels)
    {
        List<Object[]> studentObjects = new ArrayList<>();

        //Inserting the objects to the object List
        for(StudentModel student : studentModels)
        {
           Object[] studentObject = new Object[3];

           studentObject[0] = student.getStudentName();

           studentObject[1] = student.getStudentPassword();

           studentObject[2] = student.getStudentEmail();

            studentObjects.add(studentObject);
        }

        String insertSql =  "INSERT INTO StudentLogin VALUES (?,?,?)";

        //Execute the query to insert the batch values to the database.
        int[] numberOfRowAffected = jdbcTemplate.batchUpdate(insertSql,
                studentObjects);

        //get the sum of row affected.
        int sum = 0;
        for(int i : numberOfRowAffected)
        {
            sum += i;
        }

        return  "Insertion Successful "+ sum +" Rows Affected.";
    }


}
