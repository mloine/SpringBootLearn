package com.xyk.cache.service;

import com.xyk.cache.bean.Employee;
import com.xyk.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    //将方法的运行结果进行缓存

    /**
     * value 缓存的名字
     * key  缓存数据时使用的key
     * cacheManager 缓存管理器
     * condition 符合指定条件的情况下缓存
     * unless 符合情况下不缓存
     * sync :是否使用异步
     * @param id
     * @return
     * key="#id" ,condition = "#id>0",unless = "#result == null"
     */
    @Cacheable( cacheNames = {"emp"})
    public Employee getEmp(Integer id){
        Employee emp = employeeMapper.getEmp (id);
        System.out.println ("当前查询的"+id+"用户信息是："+emp);
        return emp;
    }
}
