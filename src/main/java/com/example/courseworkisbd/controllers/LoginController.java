package com.example.courseworkisbd.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {
    @GetMapping("main")
    public String index(){
        return "main";
    }

    @GetMapping("login")
    public String login(){return "login";}
}
