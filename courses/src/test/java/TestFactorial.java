import FactorialFirst.Factorial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestFactorial {
    @Test
    void testFactorialOne() {
        assertEquals(1, Factorial.getFactorial(0));
    }

    @Test
    void testFactorialTwo() {
        assertEquals(1, Factorial.getFactorial(1));
    }

    @Test
    void testFactorialThree() {
        assertEquals(2, Factorial.getFactorial(2));

    }

    @Test
    void testFactorialFour() {
        assertEquals(2432902008176640000l, Factorial.getFactorial(20));
    }

    @Test
    void testFactorialFive() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.getFactorial(-5));


    }


}