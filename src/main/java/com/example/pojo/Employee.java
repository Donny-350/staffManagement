package com.example.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
@NoArgsConstructor
public class Employee {

    private int id;
    private String employeeName;
    private String email;
    private int gender;
    private int departmentId;
    private Date date;


}
