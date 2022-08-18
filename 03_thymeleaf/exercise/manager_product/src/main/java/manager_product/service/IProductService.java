package manager_product.service;

import manager_product.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    void edit(int id, Product product);

    void remove(int id);

    Product findGetId(int id);

    List<Product> searchProductByName(String searchName);
}
