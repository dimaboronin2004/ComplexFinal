import org.example.Complex;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.example.Complex.toComplex;

public class ComplexTest {

    public void assertEqualsComplex(Complex expected, Complex actual, double eps) {
        Assertions.assertEquals(expected.getRe(), actual.getRe(), eps);
        Assertions.assertEquals(expected.getIm(), actual.getIm(), eps);
    }

    @Test
    void toComplexTest() {
        assertEqualsComplex(new Complex(3, 7), toComplex("3+7i"), 1e-10);
    }

    @Test
    void complexPlusTest() {
        assertEqualsComplex(new Complex(10, 8), new Complex(3, 2).plus(new Complex(7, 6)), 1e-10);
    }

    @Test
    void unaryMinusTest() {
        assertEqualsComplex(new Complex(-7, -15), new Complex(7, 15).unaryMinus(), 1e-10);
    }

    @Test
    void complexMinusTest() {
        assertEqualsComplex(new Complex(-5, 3), new Complex(11, 8).minus(new Complex(16, 5)), 1e-10);
    }

    @Test
    void complexTimesTest() {
        assertEqualsComplex(new Complex(10, 10), new Complex(1, 3).times(new Complex(4, -2)), 1e-10);
    }

    @Test
    void complexDivTest() {
        assertEqualsComplex(new Complex(1.6, 0.2), new Complex(3, 2).div(new Complex(2, 1)), 1e-10);
    }

    @Test
    void complexEqualsTest() {
        Assertions.assertTrue(new Complex(7, -2).equals(new Complex(7, -2)));
        Assertions.assertFalse(new Complex(4, 9).equals(new Complex(3, 8)));
    }

    @Test
    void complexToStringTest() {
        Assertions.assertEquals("6.0+4.0i", new Complex(6, 4).toString());
    }
}
