package com.example.EmployeeService.Controller;

import com.example.EmployeeService.Repository.EmployeeRepository;
import com.example.EmployeeService.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController
{
    @Autowired
    private EmployeeRepository employeeRepository;

    private static final Logger LOGGER= LoggerFactory.getLogger(EmployeeController.class);

    @PostMapping
    public Employee add(@RequestBody Employee d){
        LOGGER.info("Employee add");
        return employeeRepository.addEmployee(d);
    }

    @GetMapping
    public List<Employee> findAll(){
        LOGGER.info("department all");
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id){
        LOGGER.info("department find");
        return employeeRepository.findById(id);
    }
    @GetMapping("/dept/{id}")
    public List<Employee> findByDeptId(@PathVariable Long id){
        LOGGER.info("department findbyDept");
        return employeeRepository.findByDepartment(id);
    }


}
