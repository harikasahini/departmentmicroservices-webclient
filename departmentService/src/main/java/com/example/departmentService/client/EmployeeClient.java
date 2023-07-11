package com.example.departmentService.client;

import com.example.departmentService.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface EmployeeClient {

    @GetExchange("employee/dept/{id}")
    public List<Employee> findByDeptId(@PathVariable Long id);

}
