package com.example.demo.StudentDao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultSetDataExtractor implements ResultSetExtractor<List<Map<String, Object>>> {
    @Override
    public List<Map<String, Object>> extractData(ResultSet rs) throws SQLException, DataAccessException {

        List<Map<String, Object>> studentsListMap = new ArrayList<>();

        while (rs.next())
        {
            Map<String,Object> studentsMap = new HashMap<>();

            studentsMap.put( "student-first-name", rs.getString("student-first-name"));
            studentsMap.put( "student-second-name", rs.getString("student-second-name"));
            studentsMap.put( "student-regno", rs.getString("student-regno"));

            studentsListMap.add(studentsMap);
        }

        {
            System.out.println("""
                    
                    List<Map<String, Object>> extractData(ResultSet rs) throws SQLException, DataAccessException
                    Data Extracted....>>>>>""");
        }

        return studentsListMap;
    }
}
