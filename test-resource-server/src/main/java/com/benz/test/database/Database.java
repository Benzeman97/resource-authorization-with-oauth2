package com.benz.test.database;

import com.benz.test.model.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {

    private static Map<String, Employee> employeeDb;

    static {

         employeeDb=new HashMap<>();
         employeeDb.put("1001",new Employee(1001,"Nafaz Benzema",78000.00));
         employeeDb.put("1002",new Employee(1002,"Kelly Brook",98000.00));
         employeeDb.put("1003",new Employee(1003,"Julia Ann",45000.00));
         employeeDb.put("1004",new Employee(1004,"Chopa Kama",22000.00));
    }

    public static Employee getEmployee(String id)
    {
          return employeeDb.get(id);
    }

    public static List<Employee> getEmployees()
    {
           return new ArrayList<>(employeeDb.values());
    }
}
