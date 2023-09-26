package com.rest.order.standard.flow.services;

import com.rest.order.standard.flow.models.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.BootstrapWith;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@BootstrapWith(SpringBootTestContextBootstrapper.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@Transactional
@AutoConfigureTestDatabase
public class OrderServiceIntegrationTests {
    @Autowired
    private OrderService orderService;

    @PersistenceContext
    private EntityManager entityManager;


    /**
     * This sanity check test fails if the application context cannot start.
     */
    @Test
    public void contextLoads() {
    }


    ///region Test suites for executable com.rest.order.standard.flow.services.OrderService.isNotEmpty


    @Test
    public void testIsNotEmpty1() {
        boolean actual = orderService.isNotEmpty();

        assertFalse(actual);
    }

    @Test
    public void testIsNotEmpty2() {
        Order order = new Order(0L, "#$\\\"'", 1, -1);
        entityManager.persist(order);
        entityManager.flush();

        boolean actual = orderService.isNotEmpty();

        assertTrue(actual);
    }

    ///endregion
}
