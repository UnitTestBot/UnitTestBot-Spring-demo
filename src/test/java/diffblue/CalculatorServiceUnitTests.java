package diffblue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.rest.order.types.inferring.Calculator;
import com.rest.order.types.inferring.CalculatorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CalculatorService.class})
@ExtendWith(SpringExtension.class)
class CalculatorServiceUnitTests {
    @MockBean
    private Calculator calculator;

    @Autowired
    private CalculatorService calculatorService;

    /**
     * Method under test: {@link CalculatorService#calcSquareSum(int, int)}
     */
    @Test
    void testCalcSquareSum() {
        when(calculator.multiply(anyInt(), anyInt())).thenReturn(5L);
        assertEquals(10L, calculatorService.calcSquareSum(3, 3));
        verify(calculator, atLeast(1)).multiply(anyInt(), anyInt());
    }

    /**
     * Method under test: {@link CalculatorService#calcSquareSum(int, int)}
     */
    @Test
    void testCalcSquareSum2() {
        when(calculator.multiply(anyInt(), anyInt())).thenReturn(5L);
        assertEquals(10L, calculatorService.calcSquareSum(1, 3));
        verify(calculator, atLeast(1)).multiply(anyInt(), anyInt());
    }

    /**
     * Method under test: {@link CalculatorService#calcSquareSum(int, int)}
     */
    @Test
    void testCalcSquareSum3() {
        when(calculator.multiply(anyInt(), anyInt())).thenReturn(5L);
        assertEquals(10L, calculatorService.calcSquareSum(0, 3));
        verify(calculator, atLeast(1)).multiply(anyInt(), anyInt());
    }

    /**
     * Method under test: {@link CalculatorService#calcSquareSum(int, int)}
     */
    @Test
    void testCalcSquareSum4() {
        when(calculator.multiply(anyInt(), anyInt())).thenReturn(5L);
        assertEquals(10L, calculatorService.calcSquareSum(-1, 3));
        verify(calculator, atLeast(1)).multiply(anyInt(), anyInt());
    }
}

