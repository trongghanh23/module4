package com.castudy.furama.controller;

import com.castudy.furama.model.Customer;
import com.castudy.furama.service.ICustomerService;
import com.castudy.furama.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping("/customer")
    public String customerList(Model model, @PageableDefault(size = 3) Pageable pageable,
                               @RequestParam Optional<String> keyword) {
        String keyWordValue = keyword.orElse("");
        model.addAttribute("customerList", this.iCustomerService.findAllSearchAndPaging(keyWordValue, pageable));
        model.addAttribute("keyWordValue");
        return ("/customer/list");
    }

    @GetMapping("/customer/showCreate")
    public String showCreate(Model model) {
        model.addAttribute("showCreate", new Customer());
        model.addAttribute("showCustomerType", this.iCustomerTypeService.findAll());
        return ("/customer/create");
    }

    @PostMapping("/create/save")
    public String save(@ModelAttribute Customer customer) {
        this.iCustomerService.save(customer);
        return "redirect:/customer";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Integer id) {
        this.iCustomerService.delete(id);
        return "redirect:/customer";
    }

    @GetMapping("/showUpdate")
    public String showEditCustomerForm(@RequestParam Integer id, Model model) {


        model.addAttribute("showCustomer", iCustomerService.getId(id));
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
        return "/customer/edit";
    }

@ExceptionHandler(value = Exception.class)
public String goError() {
    return "error";
}
}
