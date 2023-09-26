package com.rest.order.standard.flow.repositories;

import com.rest.order.standard.flow.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
