package com.castudy.furama.service.impl;

import com.castudy.furama.model.Contract;
import com.castudy.furama.repository.ContractRepository;
import com.castudy.furama.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service

public class ContractService implements IContractService {

        @Autowired
        ContractRepository contractRepository;

        @Override
        public Page<Contract> findAll(Pageable pageable, String nameFind) {
            return contractRepository.findAll(pageable, "%" + nameFind + "%");
        }

        @Override
        public void save(Contract contract) {
            contractRepository.save(contract);
        }

}
