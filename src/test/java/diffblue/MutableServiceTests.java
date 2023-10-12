package diffblue;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.rest.order.mutable.MutableService;
import org.junit.jupiter.api.Test;

class MutableServiceTests {
    @Test
    void testSetState() {
        MutableService mutableService = new MutableService();
        mutableService.setState(1);
        int actualAndSetToOne = mutableService.getAndSetToOne();
        int actualAndSetToTwo = mutableService.getAndSetToTwo();
        assertEquals(1, actualAndSetToOne);
        assertEquals(1, actualAndSetToTwo);
        assertEquals(2, mutableService.getState());
    }
}

