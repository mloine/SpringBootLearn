package com.xyk.springboot04webjsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("/abc")
    public String hello(Model model){
        System.out.println ("----------------------------------------------------");
        model.addAttribute ("msg","你好");
        return "success";

    }
}
