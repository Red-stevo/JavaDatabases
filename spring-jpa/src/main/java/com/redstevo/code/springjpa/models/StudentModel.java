package com.redstevo.code.springjpa.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class StudentModel {

    @Id
    @GeneratedValue
    private Long studentId;

    private String studentName;

    private String studentEmail;
}
