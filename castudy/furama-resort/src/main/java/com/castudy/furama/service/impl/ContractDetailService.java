package com.castudy.furama.service.impl;

import com.castudy.furama.model.ContractDetail;
import com.castudy.furama.repository.IContractDetailRepository;
import com.castudy.furama.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    IContractDetailRepository contractDetailRepository;

    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }
//    @Override
//    public List<ContractDetail> findAllByContractId(Integer id) {
//        return this.contractDetailRepository.findAllByContract_IdContract(id);
//    }
}
