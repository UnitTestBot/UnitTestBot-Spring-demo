package com.rest.order.standard.flow.services;

import com.rest.order.standard.flow.repositories.OrderRepository;
import com.rest.order.standard.flow.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public boolean isMajorityExpensive(int threshold) {
        List<Order> allOrders = orderRepository.findAll();

        if (allOrders.isEmpty()) {
            return false;
        }

        List<Order> expensiveOrders = new ArrayList<>();
        for (Order order: allOrders) {
            if (order != null && order.getPrice() > threshold) {
                expensiveOrders.add(order);
            }
        }

        return expensiveOrders.size() > allOrders.size() / 2;
    }

    public boolean isNotEmpty() {
        List<Order> orders = orderRepository.findAll();
        return orders.size() > 0;
    }
}
