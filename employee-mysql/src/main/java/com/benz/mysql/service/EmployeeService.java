package com.benz.mysql.service;

import com.benz.mysql.dao.EmployeeDAO;
import com.benz.mysql.entity.Employee;
import com.benz.mysql.exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeService(EmployeeDAO employeeDAO)
    {
        this.employeeDAO=employeeDAO;
    }

    public List<Employee> getEmployees()
    {
       List<Employee> employees= employeeDAO.getEmployees()
                                      .orElseThrow(()->new DataNotFoundException("Data Not Available"));

       employees.stream().forEach(
               emp->{
                   System.out.println(emp.getEmployeeId()+"\t"+emp.getEmpName()+"\t"+emp.getSalary());
               }
       );
       return employees;
    }
}
