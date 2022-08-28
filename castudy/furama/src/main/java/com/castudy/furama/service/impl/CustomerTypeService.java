package com.castudy.furama.service.impl;

import com.castudy.furama.model.CustomerType;
import com.castudy.furama.repository.ICustomerTypeRepository;
import com.castudy.furama.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    ICustomerTypeRepository iCustomerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return iCustomerTypeRepository.findAll();
    }

    @Override
    public void save(CustomerType customerType) {
        iCustomerTypeRepository.save(customerType);
    }
}
