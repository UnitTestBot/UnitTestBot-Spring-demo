package com.rest.order.standard.flow.services;

import com.rest.order.standard.flow.models.Order;
import com.rest.order.standard.flow.repositories.OrderRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public final class OrderServiceUselessUnitTests {
    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderRepository orderRepositoryMock;

    private AutoCloseable mockitoCloseable;

    ///region Test suites for executable com.rest.order.standard.flow.services.OrderService.isNotEmpty


    @Test
    public void testIsNotEmpty1() {
        List listMock = mock(List.class);
        (when(listMock.size())).thenReturn(0);
        (when(orderRepositoryMock.findAll())).thenReturn(listMock);

        boolean actual = orderService.isNotEmpty();

        assertFalse(actual);
    }

    @Test
    public void testIsNotEmpty2() {
        LinkedList linkedList = new LinkedList();
        Order orderMock = mock(Order.class);
        linkedList.add(orderMock);
        (when(orderRepositoryMock.findAll())).thenReturn(linkedList);

        boolean actual = orderService.isNotEmpty();

        assertTrue(actual);
    }

    ///endregion


    @BeforeEach
    public void setUp() {
        mockitoCloseable = openMocks(this);
    }

    @AfterEach
    public void tearDown() throws Exception {
        mockitoCloseable.close();
    }

}
