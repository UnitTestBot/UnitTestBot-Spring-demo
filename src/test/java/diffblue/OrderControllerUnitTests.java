package diffblue;

import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

import com.rest.order.standard.flow.controllers.OrderController;
import com.rest.order.standard.flow.services.OrderService;
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

@ContextConfiguration(classes = {OrderController.class})
@ExtendWith(SpringExtension.class)
class OrderControllerUnitTests {
    @Autowired
    private OrderController orderController;

    @MockBean
    private OrderService orderService;

    /**
     * Method under test: {@link OrderController#isMajorityExpensive(int)}
     */
    @Test
    void testIsMajorityExpensive() throws Exception {
        when(orderService.isMajorityExpensive(anyInt())).thenReturn(true);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/isMajorityExpensive");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("threshold", String.valueOf(1));
        ResultActions resultActions = MockMvcBuilders.standaloneSetup(orderController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));
        ContentResultMatchers contentResult = MockMvcResultMatchers.content();
        resultActions.andExpect(contentResult.string(Boolean.TRUE.toString()));
    }

    /**
     * Method under test: {@link OrderController#isMajorityExpensive(int)}
     */
    @Test
    void testIsMajorityExpensive2() throws Exception {
        when(orderService.isMajorityExpensive(anyInt())).thenReturn(false);
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
}

