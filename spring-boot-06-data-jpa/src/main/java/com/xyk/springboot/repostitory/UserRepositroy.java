package com.xyk.springboot.repostitory;

import com.xyk.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

//继承JpaRepository来完成对数据库的操作
public interface UserRepositroy extends JpaRepository<User,Integer>{



}
