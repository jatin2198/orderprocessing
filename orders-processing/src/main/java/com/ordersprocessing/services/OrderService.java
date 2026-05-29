package com.ordersprocessing.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ordersprocessing.model.Order;

@Service
public class OrderService {

    private List<Order> orders = new ArrayList<>();

    public void save(Order order) {
        orders.add(order);
    }

    public List<Order> getAllOrders() {
        return orders;
    }
}
