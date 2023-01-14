package de.telran.shop.repository;

import de.telran.shop.entity.Order;

public class OrderRepository implements CommonRepository<Order> {

    @Override
    public Order save(Order entity) {
        return null;
    }

    @Override
    public Iterable<Order> save(Iterable<Order> entities) {
        return null;
    }

    @Override
    public Order delete(String id) {
        return null;
    }

    @Override
    public Order findById(String id) {
        return null;
    }

    @Override
    public Iterable<Order> findAll() {
        return null;
    }

}
