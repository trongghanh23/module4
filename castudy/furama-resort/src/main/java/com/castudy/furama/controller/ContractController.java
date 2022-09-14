package com.castudy.furama.controller;

import com.castudy.furama.model.Contract;
import com.castudy.furama.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller

public class ContractController {
    @Autowired
    IContractService icontractService;

    @Autowired
    IAttachFacilityService iattachFacilityService;

    @Autowired
    IContractDetailService icontractDetailService;

    @Autowired
    ICustomerService icustomerService;

    @Autowired
    IFacilityService ifacilityService;

    @GetMapping("/contract")
    public String showList(Model model, @Param("nameFind") Optional<String> nameFind, @PageableDefault(value = 6, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        model.addAttribute("nameFind", nameFind.orElse(""));
        model.addAttribute("contracts", icontractService.findAll(pageable, nameFind.orElse("")));
        model.addAttribute("attachFacilities", iattachFacilityService.findAll());
        model.addAttribute("contractDetails", icontractDetailService.findAll());
        model.addAttribute("contractCreate", new Contract());
        return "contract/list";
    }


    @GetMapping("contract/create")
    public String showCreate(Model model, @Param("nameFind") Optional<String> nameFind, @PageableDefault(value = 6, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        model.addAttribute("contractCreate", new Contract());
        model.addAttribute("nameFind", nameFind.orElse(""));
        model.addAttribute("contracts", icontractService.findAll(pageable, nameFind.orElse("")));
        model.addAttribute("customers", icustomerService.findAll());
        model.addAttribute("facilities", ifacilityService.findAll());
        model.addAttribute("attachFacilities", iattachFacilityService.findAll());
        model.addAttribute("contractDetails", icontractDetailService.findAll());
        return "contract/list";
    }

    @PostMapping("contract/create")
    public String create(Contract contract, RedirectAttributes redirectAttributes) {
        icontractService.save(contract);
        redirectAttributes.addFlashAttribute("success", "Add Contract Success!");
        return "redirect:/contract";
    }
}
//
//    @GetMapping("/contract")
//    public String goListContract(Model model,
//                                 @PageableDefault(size = 5) Pageable pageable,
//                                 @RequestParam Optional<String> keyword){
//        String keywordValue = keyword.orElse("");
//
//        Map<Integer, Double> map = new HashMap<>();
//        Page<Contract> contractPage = this.icontractService.findAllByEndDayContaining(keywordValue,pageable);
//        double price ;
//        for (Contract contract: contractPage){
//            price = 0;
//            for (ContractDetail contractDetail : contract.getContractDetailList()){
//                price+= contractDetail.getQuantity()*contractDetail.getAttachFacility().getCost();
//            }
//            map.put(contract.getId(),price);
//        }
//        model.addAttribute("total",map);
//        model.addAttribute("contractList",
//                this.icontractService.findAllByEndDayContaining(keywordValue,pageable));
//        model.addAttribute("keywordValue",keywordValue);
//        return "contract/list";
//    }
//
//    @PostMapping("/add")
//    public String add(@ModelAttribute Contract contract, RedirectAttributes redirectAttributes){
//        this.icontractService.save(contract);
//        redirectAttributes.addFlashAttribute("mess","Thêm mới hợp đồng thành công");
//        return "contract/list";
//    }


