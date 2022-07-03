package com.custom.marketPlace.repo.impl;

import com.custom.marketPlace.constants.Qualifiers;
import com.custom.marketPlace.model.Order;
import com.custom.marketPlace.repo.AbstractRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.UUID;

@Repository(Qualifiers.ORDER_REPO)
public class OrderRepository extends AbstractRepository<Order> {

    public OrderRepository(EntityManager em) {
        super(em);
    }

    @Override
    public Order findById(UUID id) {
        return em.find(Order.class, id);
    }
}
