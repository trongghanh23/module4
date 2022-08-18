package manager_product.service.impl;

import manager_product.model.Product;
import manager_product.repository.IProductRepository;
import manager_product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);

    }

    @Override
    public void edit(int id, Product product) {
        iProductRepository.edit(id, product);
    }

    @Override
    public void remove(int id) {
        iProductRepository.remove(id);
    }

    @Override
    public Product findGetId(int id) {
        return iProductRepository.findGetId(id);
    }

    @Override
    public List<Product> searchProductByName(String searchName) {
        return iProductRepository.searchProductByName(searchName);
    }
}
