package com.custom.marketPlace.repo.impl;

import com.custom.marketPlace.model.Product;
import com.custom.marketPlace.repo.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.UUID;

public class ProductRepositoryImpl implements ProductRepository {
    private final EntityManager em;

    public ProductRepositoryImpl(EntityManager em){
        this.em = em;
    }

    @Override
    public Product getProductById(UUID id) {
        return em.find(Product.class, id);
    }

    @Override
    public Product getProductByName(String name) {
        TypedQuery<Product> q = em.createQuery("SELECT p FROM Product p where p.name = :name", Product.class);
        q.setParameter("name", name);
        return q.getSingleResult();
    }

    @Override
    public Product saveProduct(Product p) {
        if (p.getId() == null) {
            em.persist(p);
        } else {
            p = em.merge(p);
        }
        return p;
    }

    @Override
    public void removeProduct(Product p) {
        if (em.contains(p)) {
            em.remove(p);
        } else {
            em.merge(p);
        }
    }

    @Override
    public void updateProductName(UUID id, String name) {
        TypedQuery<Product> q = em.createQuery("UPDATE Product p SET p.name = :name where p.id = :id", Product.class);
        q.setParameter("id", id);
        q.setParameter("name", name);
    }

    @Override
    public void updateProductPrice(UUID id, Double price) {
        TypedQuery<Product> q = em.createQuery("UPDATE Product p SET p.price = :price where p.id = :id", Product.class);
        q.setParameter("id", id);
        q.setParameter("price", price);
    }

    @Override
    public void updateProductsCount(UUID id, Integer newCount) {
        TypedQuery<Product> q = em.createQuery("UPDATE Product p SET p.availableCount = :count where p.id = :id", Product.class);
        q.setParameter("id", id);
        q.setParameter("count", newCount);
    }
}
