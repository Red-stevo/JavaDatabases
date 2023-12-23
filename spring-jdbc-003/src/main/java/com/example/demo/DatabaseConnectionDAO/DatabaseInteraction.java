package com.example.demo.DatabaseConnectionDAO;

import com.example.demo.models.StudentModel;
import com.example.demo.models.datainput.StudentDataInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class DatabaseInteraction {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    StudentDataInput studentDataInput;

    public void insertData()
    {

        StudentModel studentModel = studentDataInput.hardCodedDataInput(); //This method returns an object of studentMOdel.

        String sql ="INSERT INTO studentInfo VALUES (?,?,?)"; //prepared statement to insert data into the table.

        Object[] object = {studentModel.getfName(), studentModel.getsName(), studentModel.getRegno()};

        int numberOfRowsAffected = jdbcTemplate.update(sql,object);

        System.out.println("\tInsertion successful.\n"+numberOfRowsAffected+" Number of Row Affected.");
    }
}
