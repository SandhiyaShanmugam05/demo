package com.example.demo.entity;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
@Data
@Document
public class Employe{
    @Id
    private String id;
    private String empId;
    private String password;
    private String empName;
    private String empEmail;
    private String empDept;
    private double empSalary;
    private String empLoc;

}

