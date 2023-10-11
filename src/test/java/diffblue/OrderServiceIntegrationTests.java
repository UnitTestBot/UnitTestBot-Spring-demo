package diffblue;

import static org.junit.jupiter.api.Assertions.assertFalse;

import com.rest.order.standard.flow.services.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class OrderServiceIntegrationTests {
    @Autowired
    private OrderService orderService;

    /**
     * Method under test: {@link OrderService#isNotEmpty()}
     */
    @Test
    void testIsNotEmpty() {
        assertFalse(orderService.isNotEmpty());
    }
}

