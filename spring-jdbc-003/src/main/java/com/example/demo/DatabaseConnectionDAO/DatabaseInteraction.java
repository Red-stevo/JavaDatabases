package com.example.demo.DatabaseConnectionDAO;

import com.example.demo.models.StudentModel;
import com.example.demo.models.datainput.StudentDataInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository("DatabaseInteraction")
public class DatabaseInteraction {

    JdbcTemplate jdbcTemplate;

    StudentDataInput studentDataInput;

    StudentRowMappingDAO studentRowMappingDAO;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setStudentDataInput(StudentDataInput studentDataInput) {
        this.studentDataInput = studentDataInput;
    }

    @Autowired
    public void setStudentRowMappingDAO(StudentRowMappingDAO studentRowMappingDAO) {
        this.studentRowMappingDAO = studentRowMappingDAO;
    }

    public void insertData()
    {

        StudentModel studentModel = studentDataInput.hardCodedDataInput(); //This method returns an object of studentMOdel.

        String sql ="INSERT INTO studentInfo VALUES (?,?,?)"; //prepared statement to insert data into the table.

        Object[] object = {studentModel.getfName(), studentModel.getsName(), studentModel.getRegno()};

        int numberOfRowsAffected = jdbcTemplate.update(sql,object);

        System.out.println("\tInsertion successful.\n"+numberOfRowsAffected+" Number of Row Affected.");
    }


    public void batchInsertion(ArrayList<StudentModel> studentList)
    {

        String sql = "INSERT INTO studentInfo (`student-first-name`,\t`student-second-name`,\t`student-regno`) VALUES (?,?,?)";
        ArrayList<Object[]> sqlargs = new ArrayList<>();

        //Moving the student studentList to the sql-args
        for(StudentModel studentModel : studentList)
        {
            Object[] studentObject = {studentModel.getfName(), studentModel.getsName(),studentModel.getRegno()};
            System.out.println(studentModel.getfName() +" "+studentModel.getsName()+" "+studentModel.getRegno());
            sqlargs.add(studentObject);
        }

        int[] numberOfRowsAffected = jdbcTemplate.batchUpdate(sql, sqlargs);

        System.out.println("\tInsertion successful.\n"+ Arrays.toString(numberOfRowsAffected) +" Number of Row Affected.");
    }

    public List<StudentModel> getStudentData() {
        String sql = "SELECT * FROM studentInfo";

        List<StudentModel> studentModelList = jdbcTemplate.query(sql, studentRowMappingDAO);

        return studentModelList;
    }

    public void printStudentModel()
    {
        List<StudentModel> studentModelList = getStudentData();

       // ArrayList<StudentModel> studentModelList = (ArrayList<StudentModel>) getStudentData();

        for(StudentModel studentModel: studentModelList)
        {
            System.out.println(studentModel);
        }
    }

    public StudentModel getStudentById(String studentId)
    {
        String selectSql = "SELECT * FROM studentInfo WHERE `student-regno` = ?;";
        StudentModel studentModel = jdbcTemplate.queryForObject(selectSql, new StudentRowMappingDAO(), studentId);

        System.out.println(studentModel);

        return studentModel;
    }
}
