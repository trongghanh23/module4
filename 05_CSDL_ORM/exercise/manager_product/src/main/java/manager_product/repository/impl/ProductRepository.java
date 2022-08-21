package manager_product.repository.impl;

import manager_product.model.Product;
import manager_product.repository.BaseRepository;
import manager_product.repository.IProductRepository;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> findAll(String name) {

        Session session = BaseRepository.sessionFactory.openSession();
        Query query = session.createQuery("SELECT p FROM Product AS p WHERE p.name LIKE :Search");
        query.setParameter("Search", '%' + name + '%');
        return query.getResultList();
    }

    @Override
    public void save(Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(product);
        entityTransaction.commit();
    }

    @Override
    public Product findGetId(int id) {
        String queryId = "SELECT p FROM Product AS p WHERE p.id = :id";
        TypedQuery<Product> query = BaseRepository.entityManager.createQuery(queryId, Product.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void edit(int id, Product product) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(product);
        entityTransaction.commit();
    }

    @Override
    public void remove(int id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.remove(BaseRepository.entityManager.find(Product.class, id));
        entityTransaction.commit();
    }

}


