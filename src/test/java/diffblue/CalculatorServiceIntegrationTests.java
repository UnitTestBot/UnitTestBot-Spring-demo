package diffblue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.rest.order.types.inferring.CalculatorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class CalculatorServiceIntegrationTests {
    @Autowired
    private CalculatorService calculatorService;

    /**
     * Method under test: {@link CalculatorService#calcSquareSum(int, int)}
     */
    @Test
    void testCalcSquareSum() {
        assertEquals(18L, calculatorService.calcSquareSum(3, 3));
        assertEquals(10L, calculatorService.calcSquareSum(1, 3));
        assertEquals(9L, calculatorService.calcSquareSum(0, 3));
        assertEquals(10L, calculatorService.calcSquareSum(-1, 3));
    }
}

