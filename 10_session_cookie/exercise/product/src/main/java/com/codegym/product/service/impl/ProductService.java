package com.codegym.product.service.impl;


import com.codegym.product.model.Product;
import com.codegym.product.repository.IProductRepository;
import com.codegym.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public void remove(int id) {
        this.productRepository.delete(this.productRepository.getById(id));
    }
}
