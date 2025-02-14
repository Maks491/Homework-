import com.beust.ah.A;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestFactorial {
    @Test
    void testOne() {
        Assert.assertEquals(Factorial.getFactorial(0), 1);
    }

    @Test
    void testTwo() {
        Assert.assertEquals(Factorial.getFactorial(1), 1);
    }

    @Test
    void testThree() {
        Assert.assertEquals(Factorial.getFactorial(2), 2);
    }

    @Test
    void testFour() {
        Assert.assertEquals(Factorial.getFactorial(20), 2432902008176640000l);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    void testFive() {
        Factorial.getFactorial(-1);

    }
}
