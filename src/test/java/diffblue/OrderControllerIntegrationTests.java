package diffblue;

import static org.mockito.Mockito.when;

import com.rest.order.standard.flow.controllers.OrderController;
import com.rest.order.standard.flow.models.Order;
import com.rest.order.standard.flow.repositories.OrderRepository;
import com.rest.order.standard.flow.services.OrderService;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {OrderController.class, OrderService.class})
@ExtendWith(SpringExtension.class)
class OrderControllerIntegrationTests {
    @Autowired
    private OrderController orderController;

    @MockBean
    private OrderRepository orderRepository;

    /**
     * Method under test: {@link OrderController#isMajorityExpensive(int)}
     */
    @Test
    void testIsMajorityExpensive() throws Exception {
        when(orderRepository.findAll()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/isMajorityExpensive");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("threshold", String.valueOf(1));
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(orderController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.FALSE.toString()));
    }

    /**
     * Method under test: {@link OrderController#isMajorityExpensive(int)}
     */
    @Test
    void testIsMajorityExpensive2() throws Exception {
        ArrayList<Order> orderList = new ArrayList<>();
        orderList.add(new Order(1L, "?", 1, 1));
        when(orderRepository.findAll()).thenReturn(orderList);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/isMajorityExpensive");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("threshold", String.valueOf(1));
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(orderController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.FALSE.toString()));
    }

    /**
     * Method under test: {@link OrderController#isMajorityExpensive(int)}
     */
    @Test
    void testIsMajorityExpensive3() throws Exception {
        ArrayList<Order> orderList = new ArrayList<>();
        orderList.add(null);
        when(orderRepository.findAll()).thenReturn(orderList);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/isMajorityExpensive");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("threshold", String.valueOf(1));
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(orderController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.FALSE.toString()));
    }

    /**
     * Method under test: {@link OrderController#isMajorityExpensive(int)}
     */
    @Test
    void testIsMajorityExpensive4() throws Exception {
        ArrayList<Order> orderList = new ArrayList<>();
        orderList.add(new Order(1L, "?", 1, 1));
        when(orderRepository.findAll()).thenReturn(orderList);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/isMajorityExpensive");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("threshold", String.valueOf(0));
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(orderController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.TRUE.toString()));
    }
}

