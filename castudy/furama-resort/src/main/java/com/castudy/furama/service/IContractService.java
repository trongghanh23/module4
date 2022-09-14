package com.castudy.furama.service;

import com.castudy.furama.model.Contract;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {

    Page<Contract> findAll(Pageable pageable, String nameFind);
//
//    void save(Contract contract);
    Page<Contract> findAllByEndDayContaining(String endDay, Pageable pageable);

    void save(Contract contract);
}
