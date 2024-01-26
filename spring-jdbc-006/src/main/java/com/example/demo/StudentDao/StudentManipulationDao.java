package com.example.demo.StudentDao;

import com.example.demo.Models.StudentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class StudentManipulationDao implements StudentDaoInterface{

    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String deleteStudentById(String studentId) {

        String deletionSql = "DELETE FROM studentInfo WHERE `student-regno` = ?";

        int numberOfRowsAffected = jdbcTemplate.update(deletionSql, studentId);

        {
            System.out.println("""
                    deleteStudentById(String studentId)...>>>
                    Deleted a student...>>>""");
        }
        return numberOfRowsAffected+"";
    }

    @Override
    public String deleteStudentByFNameOrSName(String fName, String sName) {
        String deletionSql = "DELETE FROM studentInfo WHERE `student-first-name` = ? OR `student-second-name` = ?";

        int noOfRowsAffected = jdbcTemplate.update(deletionSql, fName,sName);

        {
            System.out.println("""
                    deleteStudentByFNameOrSName(String fName, String sName..>>>)
                    deletion complete...>>>""");
        }
        return noOfRowsAffected+"";
    }

    @Override
    public List<Map<String,Object>> selectStudentByName(String studentName) {

        {
            System.out.println("""
                    
                    List<StudentModel> selectStudentByName(String studentName)....>>>>>>
                    Extracting Students from the database...>>>
                    """);
        }

        String selectSql = "SELECT * FROM studentInfo WHERE `student-first-name` = ?";

        List<Map<String, Object>> studentModels;

        studentModels = jdbcTemplate.query(selectSql, new ResultSetDataExtractor(), studentName);

        return studentModels;
    }

    @Override
    public Map<String, List<String>> selectAddressGroupedData() {

        String selectSql = "SELECT  `student-second-name`, Address FROM studentInfo";

        Map<String,List<String>> groupedStudentMap = jdbcTemplate.query(selectSql,new GroupedDataResultSetExtractor());

        return groupedStudentMap;
    }

    public void cleanUpTable()
    {
        String cleanUpSql = "TRUNCATE TABLE studentInfo";

        jdbcTemplate.execute(cleanUpSql);

        {
            System.out.println("""
                    
                    The table is Cleaned up....>>>>""");
        }
    }
}
