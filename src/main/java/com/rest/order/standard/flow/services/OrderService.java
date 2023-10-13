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

    /**
     * This method is used to show the basic ideas of Spring
     * services or DAO classes testing in UnitTestBot.
     *
     * While generating unit tests, we should mock the behavior
     * of external calls and test the internal logic of a unit.
     */
    public boolean isMajorityExpensive(int threshold) {
        // external call to be mocked
        List<Order> allOrders = orderRepository.findAll();

        // internal logic to be tested (up to the end of the method)
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

    /**
     * This method differs from the first one in the lack
     * of internal logic. Thus, generating unit tests for
     * it seems to be useless.
     *
     * It is better to generate UnitTestBot integration tests
     * that will check the service behavior in interaction
     * with the corresponding repository.
     */
    public boolean isNotEmpty() {
        // external call to be mocked
        List<Order> orders = orderRepository.findAll();

        // internal logic
        return orders.size() > 0;
    }
}
