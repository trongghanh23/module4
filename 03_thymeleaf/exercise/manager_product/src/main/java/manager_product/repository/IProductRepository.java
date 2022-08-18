package manager_product.repository;

import manager_product.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void save(Product product);

    Product findGetId(int id);

    void edit(int id, Product product);

    List<Product> searchProductByName(String searchName);

    void remove(int id);
}
