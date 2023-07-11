package com.example.departmentService.controller;

import com.example.departmentService.client.EmployeeClient;
import com.example.departmentService.model.Department;
import com.example.departmentService.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private EmployeeClient employeeClient;
    @Autowired
    private DepartmentRepository departmentRepository;

    private static final Logger LOGGER= LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping
    public Department add(@RequestBody Department d){
        LOGGER.info("department add");
        return departmentRepository.addDepartment(d);
    }

    @GetMapping
    public List<Department> findAll(){
        LOGGER.info("department all");
        return departmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Department findById(@PathVariable Long id){
        LOGGER.info("department find");
        return departmentRepository.findById(id);
    }

    @GetMapping("/with-employees")
    public List<Department> findAllWithEmployees(){
        LOGGER.info("department all");
        List<Department> d=departmentRepository.findAll();
        d.forEach(department -> department.setEmployees(employeeClient.findByDeptId(department.getId())));
        return d;
    }
}
