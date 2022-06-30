package com.custom.marketPlace.repo.impl;

import com.custom.marketPlace.enums.Status;
import com.custom.marketPlace.model.Address;
import com.custom.marketPlace.model.Order;
import com.custom.marketPlace.model.Product;
import com.custom.marketPlace.model.Profile;
import com.custom.marketPlace.repo.OrderRepository;
import org.aspectj.weaver.ast.Or;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class OrderRepositoryImpl implements OrderRepository {
    private EntityManager em;

    public OrderRepositoryImpl(EntityManager em){
        this.em = em;
    }

    @Override
    public Order getOrderById(UUID id) {
        return em.find(Order.class, id);
    }

    @Override
    public List<Order> getOrdersByAddress(Address address) {
        TypedQuery<Order> q = em.createQuery("SELECT o FROM Order o where o.address = :address", Order.class);
        q.setParameter("address", address);
        return q.getResultList();
    }

    @Override
    public List<Order> getOrdersByProfile(Profile customer) {
        TypedQuery<Order> q = em.createQuery("SELECT o FROM Order o where o.customer = :customer", Order.class);
        q.setParameter("customer", customer);
        return q.getResultList();
    }

    @Override
    public Order saveOrder(Order o) {
        if (o.getId() == null) {
            em.persist(o);
        } else {
            o = em.merge(o);
        }
        return o;
    }

    @Override
    public void removeOrder(Order o) {
        if (em.contains(o)) {
            em.remove(o);
        } else {
            em.merge(o);
        }
    }

    @Override
    public void updateOrderAddress(UUID id, Address address) {
        TypedQuery<Order> q = em.createQuery("UPDATE Order o SET o.address = :address where o.id = :id", Order.class);
        q.setParameter("id", id);
        q.setParameter("address", address);
    }

    @Override
    public void updateOrderDeliveryDate(UUID id, LocalDate date) {
        TypedQuery<Order> q = em.createQuery("UPDATE Order o SET o.deliveryDate = :date where o.id = :id", Order.class);
        q.setParameter("id", id);
        q.setParameter("date", date);
    }

    @Override
    public void updateOrderShippmentDate(UUID id, LocalDate date) {
        TypedQuery<Order> q = em.createQuery("UPDATE Order o SET o.shipmentDate = :date where o.id = :id", Order.class);
        q.setParameter("id", id);
        q.setParameter("date", date);
    }

    @Override
    public void updateOrderStatus(UUID id, Status status) {
        TypedQuery<Order> q = em.createQuery("UPDATE Order o SET o.status = :status where o.id = :id", Order.class);
        q.setParameter("id", id);
        q.setParameter("status", status);
    }
}
