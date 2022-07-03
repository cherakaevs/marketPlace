package com.custom.marketPlace.services.impl;

import com.custom.marketPlace.constants.Qualifiers;
import com.custom.marketPlace.model.Order;
import com.custom.marketPlace.repo.IRepository;
import com.custom.marketPlace.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(Qualifiers.ORDER_SERVICE)
public class OrderService extends AbstractService<Order> {

    @Autowired
    public OrderService(@Qualifier(Qualifiers.ORDER_REPO) IRepository<Order> repository) {
        super(repository);
    }
}
