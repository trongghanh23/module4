package com.castudy.furama.controller;

import com.castudy.furama.dto.CustomerDto;
import com.castudy.furama.dto.CustomerTypeDto;
import com.castudy.furama.model.Customer;
import com.castudy.furama.model.CustomerType;
import com.castudy.furama.service.ICustomerService;
import com.castudy.furama.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
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
        model.addAttribute("customers", new CustomerDto());
        model.addAttribute("showCustomerType", this.iCustomerTypeService.findAll());
        return ("/customer/create");
    }

    @PostMapping("/create/save")

    public String create(@ModelAttribute("customers") @Valid CustomerDto customerDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("showCustomerType", this.iCustomerTypeService.findAll());

            return ("customer/create");

        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);

        CustomerType customerType = new CustomerType();
        customerType.setCode(customerDto.getCustomerType().getCode());
        customer.setCustomerType(customerType);

        this.iCustomerService.save(customer);

        redirectAttributes.addFlashAttribute("message", " add new successfully! ");
        return "redirect:/customer";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        this.iCustomerService.delete(id);
        redirectAttributes.addFlashAttribute("message", "successfully delete");
        return "redirect:/customer";
    }


    @GetMapping("/showUpdate")
    public String showEditCustomerForm(@RequestParam Integer id, Model model) {

        model.addAttribute("customer",this.iCustomerService.getId(id));
        model.addAttribute("showCustomerType", this.iCustomerTypeService.findAll());

        return "/customer/edit";
    }


    @PostMapping("/update/customer")
    public String updateSong(@ModelAttribute("customer") @Valid CustomerDto customerDto,
                             BindingResult bindingResult ,RedirectAttributes redirectAttributes) {
        new CustomerDto().validate(customerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/customer/edit";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        CustomerType customerType = new CustomerType();

        BeanUtils.copyProperties(customerDto, customerType);
        iCustomerService.save(customer);

        redirectAttributes.addFlashAttribute("message",
                "successfully update");

        return "redirect:/customer";
    }


    @ExceptionHandler(value = Exception.class)
    public String goError() {
        return "error";
    }
}
