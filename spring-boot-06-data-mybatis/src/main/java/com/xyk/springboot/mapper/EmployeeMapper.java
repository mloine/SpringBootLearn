package com.xyk.springboot.mapper;

import com.xyk.springboot.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

//@Mapper  将接口扫描到容器中
public interface EmployeeMapper {

    public Employee getEmpMapper(Integer id);

    public void insertEmp(EmployeeMapper employeeMapper);

}
