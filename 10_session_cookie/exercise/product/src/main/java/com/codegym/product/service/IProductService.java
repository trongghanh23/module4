package com.codegym.product.service;


import com.codegym.product.model.Product;

import java.util.Optional;

public interface IProductService {

    Iterable<Product> findAll();

    Optional<Product> findById(Integer id);

    void save(Product product);

    void remove(int id);
}