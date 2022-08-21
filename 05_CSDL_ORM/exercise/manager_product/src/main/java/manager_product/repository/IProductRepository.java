package manager_product.repository;

import manager_product.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll(String name);

    void save(Product product);

    Product findGetId(int id);

    void edit(int id, Product product);

    void remove(int id);
}
