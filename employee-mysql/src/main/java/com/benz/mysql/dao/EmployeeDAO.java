package com.benz.mysql.dao;

import com.benz.mysql.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee,Integer> {

    Optional<Employee> getEmployeeByEmployeeId(int empId);

    @Query("from Employee")
    Optional<List<Employee>> getEmployees();
}
