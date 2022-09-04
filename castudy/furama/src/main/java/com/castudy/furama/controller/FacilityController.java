package com.castudy.furama.controller;

import com.castudy.furama.model.Facility;
import com.castudy.furama.service.IFacilityService;
import com.castudy.furama.service.IFacilityTypeService;
import com.castudy.furama.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class FacilityController {
  @Autowired
    private IFacilityService iFacilityService;
  @Autowired
    private IFacilityTypeService iFacilityTypeService;
  @Autowired
    private IRentTypeService iRentTypeService;

    @GetMapping("/facility")
    public String customerList(Model model, @PageableDefault(size = 2) Pageable pageable,
                               @RequestParam Optional<String> keyword) {
        String keyWordValue = keyword.orElse("");
        model.addAttribute("facility", this.iFacilityService.findAllSearchAndPaging(keyWordValue, pageable));
        model.addAttribute("keyWordValue");
        return ("/facility/list");
    }

    @GetMapping("/facility/showCreate")
    public String showCreate(Model model) {
        model.addAttribute("showCreate", new Facility());
        model.addAttribute("showFacilityType", this.iFacilityTypeService.findAll());
        model.addAttribute("showRentType", this.iRentTypeService.findAll());
        return ("/facility/create");
    }

    @PostMapping("/create/save/facility")
    public String save(@ModelAttribute Facility facility) {
        this.iFacilityService.save(facility);
        return "redirect:/facility";
    }

    @PostMapping("/delete/facility")
    public String delete(@RequestParam Integer id) {
        this.iFacilityService.delete(id);
        return "redirect:/facility";
    }

    @GetMapping("/showUpdate/facility")
    public String showEditFacility(@RequestParam Integer id, Model model) {


        model.addAttribute("showFacility", iFacilityService.getId(id));
        model.addAttribute("facilityTypeList", iFacilityTypeService.findAll());
        model.addAttribute("RentTypeList", iRentTypeService.findAll());
        return "/facility/edit";
    }

}
