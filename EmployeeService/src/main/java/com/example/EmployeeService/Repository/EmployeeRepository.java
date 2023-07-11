package com.example.EmployeeService.Repository;

import com.example.EmployeeService.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    private List<Employee> employees=new ArrayList<>();

    public Employee addEmployee(Employee employee){
        employees.add(employee);
        return employee;
    }

    public Employee findById(Long Id)
    {
        return employees.stream().filter(x->x.id()==Id).findFirst().orElseThrow();
    }

    public List<Employee> findAll(){
        return employees;
    }

    public List<Employee> findByDepartment(Long departmentId)
    {
        return employees.stream().filter(x->x.departmentId()==departmentId).toList();
    }
}
