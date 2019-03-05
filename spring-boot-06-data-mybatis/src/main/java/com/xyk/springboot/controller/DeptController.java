package com.xyk.springboot.controller;

import com.xyk.springboot.bean.Department;
import com.xyk.springboot.bean.Employee;
import com.xyk.springboot.mapper.DepartmentMapper;
import com.xyk.springboot.mapper.EmployeeMapper;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

    /**
     *
     */
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id){
        return departmentMapper.getDeptById (id);
    }


    @GetMapping("/dept")
    public Department insertDepartment(Department department){

        System.out.println ("---------------------------------------insert department--------------");
        departmentMapper.insertDept (department);
        System.out.println ("---------------------------------------insert department ed--------------");

        return department;
    }


    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id){
         return employeeMapper.getEmpMapper (id);
    }

    public void insertEmp(Employee employee){

    }
}
