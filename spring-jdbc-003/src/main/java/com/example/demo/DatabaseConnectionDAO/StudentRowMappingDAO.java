package com.example.demo.DatabaseConnectionDAO;

import com.example.demo.models.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Component
public class StudentRowMappingDAO implements RowMapper<StudentModel> {

    @Override
    public StudentModel mapRow(ResultSet rs, int rowNum) throws SQLException {

        StudentModel studentModel = new StudentModel();

        studentModel.setRegno(rs.getString("student-regno"));
        //System.out.println(studentModel.getRegno());
        studentModel.setfName(rs.getString("student-first-name"));
        //System.out.println(studentModel.getfName());
        studentModel.setsName(rs.getString("student-second-name"));
        //System.out.println(studentModel.getsName());

        return studentModel;
    }
}
