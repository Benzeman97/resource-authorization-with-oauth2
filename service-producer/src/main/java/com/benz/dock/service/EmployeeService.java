package com.benz.dock.service;

import com.benz.dock.database.EmployeeDb;
import com.benz.dock.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    public Employee getEmployee(String eid)
    {
       return EmployeeDb.getEmployee(eid);
    }

    public List<Employee> getEmployees()
    {
        return EmployeeDb.getEmployees();
    }
}
