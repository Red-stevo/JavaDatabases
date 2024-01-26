package com.example.demo.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import java.util.UUID;


@Getter
@Setter
@Component
@ToString
public class DemoModel {

    private UUID generateId;
    private int id;

    public DemoModel()
    {
        generateId = new UUID(1,1);
        System.out.println("The generated id is : "+generateId);
    }

    private String name;


}
