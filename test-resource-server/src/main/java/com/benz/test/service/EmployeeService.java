package com.benz.test.service;

import com.benz.test.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee getEmployee(String id);

    List<Employee> getEmployees();
}
