package com.benz.test.service.impl;

import com.benz.test.database.Database;
import com.benz.test.exception.DataNotFoundException;
import com.benz.test.model.Employee;
import com.benz.test.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public Employee getEmployee(String id) {
            Employee employee=Database.getEmployee(id);
            if(employee!=null)
                return employee;
            else
                throw new DataNotFoundException("Data not found with "+id);
    }

    @Override
    public List<Employee> getEmployees() {
         List<Employee> employees=Database.getEmployees();

         if(employees.size()!=0)
             return employees;
         else
             throw new DataNotFoundException("Data Not Available");
    }
}
