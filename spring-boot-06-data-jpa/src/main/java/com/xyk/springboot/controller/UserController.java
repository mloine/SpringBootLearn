package com.xyk.springboot.controller;

import com.xyk.springboot.entity.User;
import com.xyk.springboot.repostitory.UserRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepositroy userRepositroy;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id){
        User one = userRepositroy.findOne (id);
        return one;
    }

    @GetMapping("/user")
    public User insertUser(User user){
        User save = userRepositroy.save (user);

        return save;
    }
}
