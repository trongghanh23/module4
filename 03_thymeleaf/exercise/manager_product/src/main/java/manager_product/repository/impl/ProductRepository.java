package manager_product.repository.impl;

import manager_product.model.Product;
import manager_product.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {

    private static Map<Integer, Product> productList = new HashMap<>();

    static {
        productList.put(1, new Product(1, "laptop1", 120000, "black", "china"));
        productList.put(2, new Product(2, "laptop2", 120000, "white", "japan"));
        productList.put(3, new Product(3, "laptop3", 150000, "read", "USA"));
        productList.put(4, new Product(4, "laptop4", 160000, "blue", "USA"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public void save(Product product) {
        product.setId((int) (Math.random() * 10000));
        productList.put(product.getId(), product);
    }

    @Override
    public Product findGetId(int id) {
        return productList.get(id);
    }

    @Override
    public void edit(int id, Product product) {
        productList.put(id, product);
    }

    @Override
    public List<Product> searchProductByName(String searchName) {
        List<Product> products = new ArrayList<>();
        for (Integer i : productList.keySet()) {
            if (productList.get(i).getName().toLowerCase().contains(searchName.toLowerCase())) {
                products.add(productList.get(i));
            }
        }
        return products;
    }

    @Override
    public void remove(int id) {
        productList.remove(id);
    }

}


