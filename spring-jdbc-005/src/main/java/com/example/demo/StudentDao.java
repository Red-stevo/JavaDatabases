package com.example.demo;

import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDao {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //loging infor to the console.
     {
        System.out.println("Configured the StudentDao object");
     }


    public String batchStudentsInsert(List<StudentModel> studentModels)
    {
        //logging to the console
        {
            System.out.println("In the batchStudentsInsert method....");
        }


        List<Object[]> studentObjects = new ArrayList<>();

        //Inserting the StudentModels to the object List
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

    //Method to add a single row to the StudentLogin table
    public String insertStudent(StudentModel studentModel){

        String insertSql = "INSERT INTO StudentLogin VALUES (?,?,?)";

        Object[] studentObject = new Object[3];

        studentObject[0] = studentModel.getStudentName();
        studentObject[1] = studentModel.getStudentPassword();
        studentObject[2] = studentModel.getStudentEmail();

        int noOfRowsAffected = jdbcTemplate.update(insertSql,studentObject);

        {
            System.out.println("Insert a single student to the database....");
        }
        return "Insertion Successful "+noOfRowsAffected+" Row Affected.";
    }

    //getting data from the database
    public List<StudentModel> getStudentsData()
    {

        {
            System.out.println("Getting all student information from" +
                    " the StudentLogin table....");
        }
        String selectionSql = "SELECT * FROM StudentLogin";

        List<StudentModel> studentModels;
        studentModels = jdbcTemplate.query(selectionSql,
                new BeanPropertyRowMapper<>(StudentModel.class));

        return studentModels;
    }

    //getting specific data from the database.
    public StudentModel getStudentData(String studentEmail)
    {
        //Login information to the console.
        {
            System.out.println("Getting specific student data from" +
                    " the StudentLogin table...");
        }
        String studentSelectSql = "SELECT * FROM StudentLogin WHERE StudentEmail = ? " ;

        StudentModel studentModel;

       studentModel = jdbcTemplate.queryForObject(studentSelectSql,
               new BeanPropertyRowMapper<>(StudentModel.class),
               studentEmail);

        return studentModel;
    }


    //Delete a Student's Information.
    public String deleteStudent(String StudentEmail)
    {
        {
            System.out.println("Deleting specific use data..." +
                    "\n Email : "+StudentEmail);
        }

        String deletionSql = "DELETE FROM StudentLogin WHERE StudentEmail = ?";

        int numberOfRowsAffected = jdbcTemplate.update(deletionSql, StudentEmail);

        return "Deletion successful... "+numberOfRowsAffected+" Rows Affected.";
    }




//method to wipe out data from the table (StudentLogin).
    public void cleanUpDataBase() {
        String truncateSql = "TRUNCATE  StudentLogin";

        jdbcTemplate.execute(truncateSql);

        //Logging to the console.
        {
            System.out.println("Database wiped clean.....");
        }
    }



}
