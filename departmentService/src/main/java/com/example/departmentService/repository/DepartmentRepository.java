package com.example.departmentService.repository;

import com.example.departmentService.model.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DepartmentRepository {

    private List<Department> departments=new ArrayList<>();

    public Department addDepartment(Department department){
        departments.add(department);
        return department;
    }

    public Department findById(Long Id)
    {
        return departments.stream().filter(x->x.getId()==Id).findFirst().orElseThrow();
    }

    public List<Department> findAll(){
        return departments;
    }


}
