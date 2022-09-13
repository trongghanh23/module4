package com.castudy.furama.service;

import com.castudy.furama.model.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();

    void save(CustomerType customerType);
}
