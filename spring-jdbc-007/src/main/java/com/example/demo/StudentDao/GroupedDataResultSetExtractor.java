package com.example.demo.StudentDao;

import com.example.demo.Models.AddressGroupedDataModel;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


@Component
public class GroupedDataResultSetExtractor implements ResultSetExtractor<Map<String, List<String>>>
{
    @Override
    public Map<String, List<String>> extractData(ResultSet rs) throws SQLException, DataAccessException {


        {
            System.out.println("""
                   Map<String, List<String>> extractData(ResultSet rs) throws SQLException, DataAccessException
                   getting and processing grouped data.....>>>>>
                    
                   """);
        }

        Map<String ,  List<String>> groupedMap = new HashMap<>();


        while(rs.next()) {
            String studentName = rs.getString("student-second-name");
            String studentAddress = rs.getString("Address");

            if (groupedMap.get(studentAddress) == null) {
                List<String> namesList = new ArrayList<>();
                namesList.add(studentName);
                groupedMap.put(studentAddress, namesList);
            } else {
                List<String> studentNamesList = groupedMap.get(studentAddress);

                studentNamesList.add(studentName);
            }
        }

        return groupedMap;
    }
}

