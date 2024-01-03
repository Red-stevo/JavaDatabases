package com.example.demo.StudentDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Component
@Transactional
public class StudentBatchDao implements StudentBatchInterface{


    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int batchUpdate(List<Object[]> batchValues) {


        {
            System.out.println("""
                    batchUpdate(List<Object[]> batchValues)
                    processing the data and performing the update...>>>>
                    """);
        }

        String updateSql = "UPDATE  studentInfo SET Address = ? WHERE `student-regno` = ? ";

        int[] numberOfRowAffected = jdbcTemplate.batchUpdate(updateSql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, (String) batchValues.get(i)[0]);
                ps.setInt(2, (Integer) batchValues.get(i)[1]);
            }

            @Override
            public int getBatchSize() {

                /*
                * this method take in the size of the list or the
                * number of objects provided
                *
                * this will determine how many times the setValues() method will be called.*/

                return batchValues.size();
            }
        });

        int sum =0;
        for (int i : numberOfRowAffected)
        {
            sum +=i;
        }

        return sum;
    }
}
