package com.codegym.product.service;


import com.codegym.product.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProduct();

    void save(Product product);

    Product findById(int id);

    void delete(int id);
}