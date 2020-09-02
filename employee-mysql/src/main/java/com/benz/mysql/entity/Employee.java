package com.benz.mysql.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="EMPLOYEE",schema = "HR")
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "EMPLOYEE_ID")
    private int employeeId;
    @Column(name = "EMP_NAME")
    private String empName;
    @Column(name = "SALARY")
    private double salary;

}
