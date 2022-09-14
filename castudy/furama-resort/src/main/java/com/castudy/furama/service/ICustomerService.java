package com.castudy.furama.service;

import com.castudy.furama.model.Customer;
import com.castudy.furama.model.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {

    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findAllSearchAndPaging(String nameCustomer, Pageable pageable);

    void save(Customer customer);

    Customer getId(Integer id);

    void delete(Integer id);

    List<Customer> findAll();



}
