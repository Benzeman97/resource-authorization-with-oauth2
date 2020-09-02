package com.benz.dock.controller;

import com.benz.dock.model.Employee;
import com.benz.dock.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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

    @PostMapping("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseEntity<?> getEmployee(@PathVariable("id") String id)
    {
        return ResponseEntity.ok(employeeService.getEmployee(id));
    }

    @GetMapping("/all")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseEntity<List<Employee>> getEmployees()
    {
       return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
    }
}
