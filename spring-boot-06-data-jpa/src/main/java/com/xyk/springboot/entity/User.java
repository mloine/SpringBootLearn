package com.xyk.springboot.entity;

import javax.persistence.*;

//配置映射关系
@Entity//告诉jpa这是一个实体类
@Table(name = "tbl_user")//指定和那个数据表对应
public class User {

    @Id//这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
    private Integer id;

    @Column(name = "last_name" ,length = 50)//这是和数据表对应的列
    private String lastName;

    @Column//剩余 默认列名就是属性名
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
 }