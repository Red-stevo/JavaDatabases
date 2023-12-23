package com.example.demo.DataBaseOperations;

import javax.sql.DataSource;

public interface JdbcComputationDAO {


    /**
     * This method allow us to connect to the database.
     * It returns a datasource object the is passed to the jdbcTemplate to make
     * the connection.
     * */
    DataSource connection();

    void insertData();

}
