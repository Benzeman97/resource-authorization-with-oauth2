package com.benz.test.controller;

import com.benz.test.model.Employee;
import com.benz.test.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
   public EmployeeController(EmployeeService employeeService)
   {
       this.employeeService=employeeService;
   }

    @PostMapping(value = "/one",consumes = {MediaType.APPLICATION_JSON_VALUE},produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Employee> getEmployee(@RequestBody Employee employee)
    {
        if(employee.getEid()!=0) {
            Employee emp=employeeService.getEmployee(String.valueOf(employee.getEid()));
            return new ResponseEntity<>(emp, HttpStatus.OK);
        }
      else
          throw new NullPointerException();

    }

    @GetMapping(value = "/all",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Employee>> getEmployees()
    {
        return ResponseEntity.ok(employeeService.getEmployees());
    }
}
