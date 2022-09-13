package com.castudy.furama.service;

import com.castudy.furama.model.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetail> findAll();

    ContractDetail save(ContractDetail contractDetail);
}