package com.castudy.furama.service.impl;

import com.castudy.furama.model.Customer;
import com.castudy.furama.repository.ICustomerRepository;
import com.castudy.furama.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;


    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findAllSearchAndPaging(String nameCustomer, Pageable pageable) {
        return iCustomerRepository.findAllByNameContaining(nameCustomer,pageable);
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Customer getId(Integer id) {
        return iCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        iCustomerRepository.deleteById(id);
    }

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }
}
