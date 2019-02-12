package com.xyk.springboot.controller;

import com.xyk.springboot.dao.DepartmentDao;
import com.xyk.springboot.dao.EmployeeDao;
import com.xyk.springboot.entities.Department;
import com.xyk.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmpController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;
    private Department department;

    //查询员工列表 返回刘表页面
    @GetMapping("/emps")
    public String list(Model model){
        //thymeleaf 默认就会拼接路径  classpath:/templates/emp/list.html

        Collection<Employee> employees =  employeeDao.getAll ();

        model.addAttribute ("emps",employees);

        return "emp/list";
    }


    //查询员工列表 返回刘表页面
    @GetMapping("/emp")
    public String toAddPage(Model model){

       Collection<Department> departments = departmentDao.getDepartments ();
       model.addAttribute ("depts",departments);

        return "emp/add";
    }

    //员工添加
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //来到员工列表页面
        employeeDao.save (employee);
        //重定向
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
       Employee employee = employeeDao.get (id);
        Collection<Department> departments = departmentDao.getDepartments ();
        model.addAttribute ("depts",departments);
       model.addAttribute ("emp",employee);

        return "emp/add";
    }

    @PutMapping("/emp")
    public  String editEmp(Employee employee){
        System.out.println (employee);
        employeeDao.save (employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        System.out.println (id);
        employeeDao.delete (id);
        return "redirect:/emps";
    }
}
