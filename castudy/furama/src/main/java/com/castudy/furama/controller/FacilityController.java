package com.castudy.furama.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FacilityController {
    @GetMapping("/showList")
    public String listFacility(){
        return ("/facility/list");
    }
}
