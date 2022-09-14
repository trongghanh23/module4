//package com.castudy.furama.controller;
//
//import com.castudy.furama.model.ContractDetail;
//import com.castudy.furama.service.IAttachFacilityService;
//import com.castudy.furama.service.IContractDetailService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//
//@RestController
//@RequestMapping(value = "/contractRest")
//public class ContractRestController {
//    @Autowired
//    private IAttachFacilityService attachFacilityService;
//
//    @Autowired
//    private IContractDetailService contractDetailService;
//
//    @GetMapping("/attachFacility")
//    public ResponseEntity<List<ContractDetail>> getAttachFacility(@RequestParam Integer id){
//
//        List<ContractDetail> contractDetailList = contractDetailService.findAllByContractId(id);
//
//        return new ResponseEntity<>(contractDetailList, HttpStatus.OK);
//    }
//}