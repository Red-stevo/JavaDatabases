package com.redstevo.code.springjpa.controllers;

import com.redstevo.code.springjpa.ServiceLayer.StudentService;
import com.redstevo.code.springjpa.models.StudentModel;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/")
@Slf4j
@Data
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<String> addStudent(@RequestBody StudentModel studentModel)
    {

        log.info("Received a request to add a student");


        String response = studentService.addStudent(studentModel);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
