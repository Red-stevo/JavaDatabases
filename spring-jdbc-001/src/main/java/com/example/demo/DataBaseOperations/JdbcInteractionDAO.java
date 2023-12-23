package com.example.demo.DataBaseOperations;

import com.example.demo.Models.StudentModel;
import com.example.demo.rowData.StudentDataGetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class JdbcInteractionDAO implements JdbcComputationDAO{
    JdbcTemplate jdbcTemplate = new JdbcTemplate(connection());//The jdbcTemplate has a construct that takes in a datasource
                                                                //Here the connection method gives us a connection object.
    @Override
    public DataSource connection() {
        String url = "jdbc:mariadb://127.0.0.1:3306/SpringJDBC";
        String userName = "steve";
        String password = "sijui!";

        DataSource dataSource = new DriverManagerDataSource(url,userName,password);
        System.out.println("Connected....");
        return dataSource;
    }

    @Override
    public void insertData()
    {
        String sql ="INSERT INTO studentInfo VALUES (?,?,?);";


        StudentModel studentModel;
        StudentDataGetter studentDataGetter  = new StudentDataGetter();


        studentModel = studentDataGetter.hardCodeStudentData();
        Object[] values = {studentModel.getfName(),studentModel.getsName(), studentModel.getRegno()};
        int numberOfRowAffected = jdbcTemplate.update(sql,values);

        System.out.println("\tData inserted successfully.\n"+numberOfRowAffected+" row affected.");


    }
}
