package com.benz.dock.database;

import com.benz.dock.exception.DataNotFoundException;
import com.benz.dock.model.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeDb {

    private static Map<String,Employee> employeeDb;

    static{
        employeeDb=new HashMap<>();
        employeeDb.put("1001",new Employee("1001","Nafaz Benzema",78000.00));
        employeeDb.put("1002",new Employee("1002","Kelly Brook",65000.00));
        employeeDb.put("1003",new Employee("1003","Doto Kama",55000.00));
        employeeDb.put("1004",new Employee("1004","Chopa Malli",43500.00));
    }

    public static Employee getEmployee(String id)
    {
            Employee emp=employeeDb.get(id);

            if(emp!=null)
                return emp;
            else
                throw new DataNotFoundException("Employee is not found with "+id);
    }

    public static List<Employee> getEmployees()
    {
         List<Employee> employees= employeeDb.values().stream().collect(Collectors.toList());

         if(employees.size()!=0)
             return employees;
         else
             throw new DataNotFoundException("Data Not Available");
    }
}
