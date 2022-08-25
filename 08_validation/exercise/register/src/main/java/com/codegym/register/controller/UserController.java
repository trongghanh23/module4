package com.codegym.register.controller;

import com.codegym.register.dto.UserDto;
import com.codegym.register.model.User;
import com.codegym.register.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import javax.validation.Valid;


@Controller
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("/")
    public String findAll(Model model) {
        model.addAttribute("userList", this.iUserService.findAll());
        return ("/list");
    }

    @GetMapping("/showCreate")
    public String update(Model model) {
        model.addAttribute("user", new User());
        return "/create";
    }

    @PostMapping("/create/save")
    public String saveCreate(@ModelAttribute("user") @Valid UserDto userDto, BindingResult bindingResult) {
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/create";
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        this.iUserService.save(user);
        return "redirect:/";
    }


}
