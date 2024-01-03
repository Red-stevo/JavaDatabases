package com.example.demo.Repository;

import com.example.demo.Models.StudentAddressUpdateModel;
import com.example.demo.StudentDao.StudentBatchDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class StudentBatchOperationsRepository {

    StudentBatchDao studentBatchDao;

    @Autowired
    public void setStudentBatchDao(StudentBatchDao studentBatchDao)
    {
        this.studentBatchDao = studentBatchDao;
    }

    public int updateStudentAddress(List<StudentAddressUpdateModel>
                                            studentAddressUpdateModelList)
    {

        {
            System.out.println("""
                    
                    updateStudentAddress(List<StudentAddressUpdateModel> studentAddressUpdateModelList)
                    formatting  data....>>>>>>
                    """);
        }

        List<Object[]> batchUpdateList = new ArrayList<>();

         Iterator<StudentAddressUpdateModel> studentAddressUpdateModelIterator
              = studentAddressUpdateModelList.iterator();

         while(studentAddressUpdateModelIterator.hasNext())
         {
             StudentAddressUpdateModel studentAddressUpdateModel
                     = studentAddressUpdateModelIterator.next();

             Object[] studentUpdateObject = {studentAddressUpdateModel.getStudentAddress(),
                 studentAddressUpdateModel.getStudentRegNo()};

             batchUpdateList.add(studentUpdateObject);
         }



        return studentBatchDao.batchUpdate(batchUpdateList);
    }




}
