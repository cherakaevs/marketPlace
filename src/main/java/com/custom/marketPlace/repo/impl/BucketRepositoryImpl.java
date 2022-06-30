package com.custom.marketPlace.repo.impl;

import com.custom.marketPlace.model.Bucket;
import com.custom.marketPlace.model.Product;
import com.custom.marketPlace.model.Profile;
import com.custom.marketPlace.repo.BucketRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

public class BucketRepositoryImpl implements BucketRepository {
    private EntityManager em;

    public BucketRepositoryImpl(EntityManager em){
        this.em = em;
    }

    @Override
    public Bucket getBucketById(UUID id) {
        return em.find(Bucket.class, id);
    }

    @Override
    public Bucket getBucketByCustomer(Profile customer) {
        TypedQuery<Bucket> q = em.createQuery("SELECT b FROM Bucket b where b.customer = :customer", Bucket.class);
        q.setParameter("customer", customer);
        return q.getSingleResult();
    }

    @Override
    public Bucket saveBucket(Bucket b) {
        if (b.getId() == null) {
            em.persist(b);
        } else {
            b = em.merge(b);
        }
        return b;
    }

    @Override
    public void removeBucket(Bucket b) {
        if (em.contains(b)) {
            em.remove(b);
        } else {
            em.merge(b);
        }
    }

    @Override
    public void updateBucketProducts(UUID id, List<Product> products) {
        TypedQuery<Bucket> q = em.createQuery("UPDATE Bucket b SET b.products = :products where b.id = :id", Bucket.class);
        q.setParameter("id", id);
        q.setParameter("products", products);
    }
}
