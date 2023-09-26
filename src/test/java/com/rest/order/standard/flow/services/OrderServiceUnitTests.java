package com.rest.order.standard.flow.services;

import com.rest.order.standard.flow.models.Order;
import com.rest.order.standard.flow.repositories.OrderRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public final class OrderServiceUnitTests {
    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderRepository orderRepositoryMock;

    private AutoCloseable mockitoCloseable;

    ///region Test suites for executable com.rest.order.standard.flow.services.OrderService.isMajorityExpensive


    @Test
    public void testIsMajorityExpensive1() {
        List listMock = mock(List.class);
        (when(listMock.isEmpty())).thenReturn(false);
        Iterator iteratorMock = mock(Iterator.class);
        (when(iteratorMock.hasNext())).thenReturn(false);
        (when(listMock.iterator())).thenReturn(iteratorMock);
        (when(listMock.size())).thenReturn(0);
        (when(orderRepositoryMock.findAll())).thenReturn(listMock);

        boolean actual = orderService.isMajorityExpensive(3);

        assertFalse(actual);
    }

    @Test
    public void testIsMajorityExpensive2() {
        List list = emptyList();
        (when(orderRepositoryMock.findAll())).thenReturn(list);

        boolean actual = orderService.isMajorityExpensive(-2147483644);

        assertFalse(actual);
    }

    @Test
    public void testIsMajorityExpensive3() {
        LinkedList linkedList = new LinkedList();
        Order orderMock = mock(Order.class);
        (when(orderMock.getPrice())).thenReturn(Integer.MIN_VALUE);
        linkedList.add(orderMock);
        (when(orderRepositoryMock.findAll())).thenReturn(linkedList);

        boolean actual = orderService.isMajorityExpensive(2);

        assertFalse(actual);
    }

    @Test
    public void testIsMajorityExpensive4() {
        ArrayList arrayList = new ArrayList();
        Order orderMock = mock(Order.class);
        (when(orderMock.getPrice())).thenReturn(-1);
        arrayList.add(orderMock);
        (when(orderRepositoryMock.findAll())).thenReturn(arrayList);

        boolean actual = orderService.isMajorityExpensive(-2147483646);

        assertTrue(actual);
    }

    @Test
    public void testIsMajorityExpensive5() {
        ArrayList arrayList = new ArrayList();
        Order orderMock = mock(Order.class);
        (when(orderMock.getPrice())).thenReturn(Integer.MAX_VALUE);
        arrayList.add(orderMock);
        Order orderMock1 = mock(Order.class);
        (when(orderMock1.getPrice())).thenReturn(Integer.MIN_VALUE);
        arrayList.add(orderMock1);
        Order orderMock2 = mock(Order.class);
        (when(orderMock2.getPrice())).thenReturn(0);
        arrayList.add(orderMock2);
        (when(orderRepositoryMock.findAll())).thenReturn(arrayList);

        boolean actual = orderService.isMajorityExpensive(16777218);

        assertFalse(actual);
    }

    @Test
    public void testIsMajorityExpensive6() {
        LinkedList linkedList = new LinkedList();
        Order orderMock = mock(Order.class);
        (when(orderMock.getPrice())).thenReturn(0);
        linkedList.add(orderMock);
        Order orderMock1 = mock(Order.class);
        (when(orderMock1.getPrice())).thenReturn(0);
        linkedList.add(orderMock1);
        Order orderMock2 = mock(Order.class);
        (when(orderMock2.getPrice())).thenReturn(0);
        linkedList.add(orderMock2);
        (when(orderRepositoryMock.findAll())).thenReturn(linkedList);

        boolean actual = orderService.isMajorityExpensive(65);

        assertFalse(actual);
    }

    @Test
    public void testIsMajorityExpensive7() {
        LinkedList linkedList = new LinkedList();
        Order orderMock = mock(Order.class);
        (when(orderMock.getPrice())).thenReturn(0);
        linkedList.add(orderMock);
        Order orderMock1 = mock(Order.class);
        (when(orderMock1.getPrice())).thenReturn(0);
        linkedList.add(orderMock1);
        Order orderMock2 = mock(Order.class);
        (when(orderMock2.getPrice())).thenReturn(2);
        linkedList.add(orderMock2);
        Order orderMock3 = mock(Order.class);
        (when(orderMock3.getPrice())).thenReturn(Integer.MIN_VALUE);
        linkedList.add(orderMock3);
        (when(orderRepositoryMock.findAll())).thenReturn(linkedList);

        boolean actual = orderService.isMajorityExpensive(-1);

        assertTrue(actual);
    }

    @Test
    public void testIsMajorityExpensive8() {
        LinkedList linkedList = new LinkedList();
        Order orderMock = mock(Order.class);
        (when(orderMock.getPrice())).thenReturn(-1);
        linkedList.add(orderMock);
        Order orderMock1 = mock(Order.class);
        (when(orderMock1.getPrice())).thenReturn(1);
        linkedList.add(orderMock1);
        Order orderMock2 = mock(Order.class);
        (when(orderMock2.getPrice())).thenReturn(Integer.MAX_VALUE);
        linkedList.add(orderMock2);
        Order orderMock3 = mock(Order.class);
        (when(orderMock3.getPrice())).thenReturn(1);
        linkedList.add(orderMock3);
        Order orderMock4 = mock(Order.class);
        (when(orderMock4.getPrice())).thenReturn(-1);
        linkedList.add(orderMock4);
        (when(orderRepositoryMock.findAll())).thenReturn(linkedList);

        boolean actual = orderService.isMajorityExpensive(-1);

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
