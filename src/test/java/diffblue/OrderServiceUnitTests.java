package diffblue;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.rest.order.standard.flow.models.Order;
import com.rest.order.standard.flow.repositories.OrderRepository;

import java.util.ArrayList;

import com.rest.order.standard.flow.services.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {OrderService.class})
@ExtendWith(SpringExtension.class)
class OrderServiceUnitTests {
    @MockBean
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;

    /**
     * Method under test: {@link OrderService#isMajorityExpensive(int)}
     */
    @Test
    void testIsMajorityExpensive() {
        when(orderRepository.findAll()).thenReturn(new ArrayList<>());
        assertFalse(orderService.isMajorityExpensive(1));
        verify(orderRepository).findAll();
    }

    /**
     * Method under test: {@link OrderService#isMajorityExpensive(int)}
     */
    @Test
    void testIsMajorityExpensive2() {
        ArrayList<Order> orderList = new ArrayList<>();
        orderList.add(new Order(1L, "Buyer", 1, 1));
        when(orderRepository.findAll()).thenReturn(orderList);
        assertFalse(orderService.isMajorityExpensive(1));
        verify(orderRepository).findAll();
    }

    /**
     * Method under test: {@link OrderService#isMajorityExpensive(int)}
     */
    @Test
    void testIsMajorityExpensive3() {
        ArrayList<Order> orderList = new ArrayList<>();
        orderList.add(null);
        when(orderRepository.findAll()).thenReturn(orderList);
        assertFalse(orderService.isMajorityExpensive(1));
        verify(orderRepository).findAll();
    }

    /**
     * Method under test: {@link OrderService#isMajorityExpensive(int)}
     */
    @Test
    void testIsMajorityExpensive4() {
        ArrayList<Order> orderList = new ArrayList<>();
        orderList.add(new Order(1L, "Buyer", 1, 1));
        when(orderRepository.findAll()).thenReturn(orderList);
        assertTrue(orderService.isMajorityExpensive(0));
        verify(orderRepository).findAll();
    }
}

