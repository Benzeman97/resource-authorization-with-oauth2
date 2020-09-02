package com.benz.dock.service;

import com.benz.dock.model.Employee;
import com.benz.dock.model.EmployeeList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private WebClient.Builder webClient;

    @Value("${service.provider.url}")
    private String service_provider_url;

    public Employee getEmployee(String id)
    {
         Employee emp = webClient.build().post().uri(service_provider_url+id)
                  .retrieve().bodyToMono(Employee.class).block();

          return emp;
    }

    public List<Employee> getEmployees()
    {
        EmployeeList empList=webClient.build().get().uri(service_provider_url+"all")
                .retrieve().bodyToMono(EmployeeList.class).block();

        return empList.getEmployees();
    }
}
