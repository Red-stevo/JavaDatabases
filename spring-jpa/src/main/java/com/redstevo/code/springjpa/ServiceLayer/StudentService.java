package com.redstevo.code.springjpa.ServiceLayer;

import com.redstevo.code.springjpa.models.StudentModel;
import com.redstevo.code.springjpa.repository.StudentRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Data
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    public String addStudent(StudentModel studentModel) {

       studentRepository.save(studentModel);


       return "Student added successfully";
    }
}
