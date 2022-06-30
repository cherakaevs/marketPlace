package com.custom.marketPlace.repo;

import com.custom.marketPlace.enums.Status;
import com.custom.marketPlace.model.Address;
import com.custom.marketPlace.model.Order;
import com.custom.marketPlace.model.Profile;
import org.aspectj.weaver.ast.Or;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface OrderRepository {
    Order getOrderById(UUID id);
    List<Order> getOrdersByAddress(Address address);
    List<Order> getOrdersByProfile(Profile profile);
    Order saveOrder(Order o);
    void removeOrder(Order o);
    void updateOrderAddress(UUID id, Address address);
    void updateOrderDeliveryDate(UUID id, LocalDate date);
    void updateOrderShippmentDate(UUID id, LocalDate date);
    void updateOrderStatus(UUID id, Status status);
}
