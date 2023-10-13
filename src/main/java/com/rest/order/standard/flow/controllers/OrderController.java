package com.rest.order.standard.flow.controllers;

import com.rest.order.standard.flow.services.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * This method is used to demonstrate how UnitTestBot
     * generates tests for REST controllers.
     *
     * The main testing idea is to create the customized
     * <code>mockMvc</code> object and to call the <code>perform</code> method on it.
     */
    @GetMapping(path = "/isMajorityExpensive")
    public boolean isMajorityExpensive(@RequestParam int threshold) {
        return orderService.isMajorityExpensive(threshold);
    }
}