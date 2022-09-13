package com.castudy.furama.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FuramaController {
    @GetMapping("/")
    public String home(){
        return "/home";
    }

    @GetMapping("/home")
    public String homes(){
        return "/home";
    }
}
