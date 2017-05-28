package codelab.reversebits;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class ReverseBitsTest {
    @Test
    @Parameters(method = "reverseParams")
    public void reverse(long expected, long a) {
        ReverseBits reverseBits = new ReverseBits();
        assertEquals(expected, reverseBits.reverse(a));
    }

    @Test
    @Parameters(method = "reverseParams")
    public void reverseSolution(long expected, long a) {
        ReverseBits reverseBits = new ReverseBits();
        assertEquals(expected, reverseBits.reverseSolution(a));
    }

    public Object[] reverseParams() {
        Object[] scenario1 = { 3221225472L, 3L };
        Object[] scenario2 = { 0L, 0L };

        return new Object[] { scenario1, scenario2 };
    }

    @Test
    @Parameters(method = "powerParams")
    public void power(long expected, int exponent, int base) {
        ReverseBits reverseBits = new ReverseBits();
        assertEquals(expected, reverseBits.power(exponent, base));
    }

    public Object powerParams() {
        Object[] scenario1 = { 32, 5, 2 };
        Object[] scenario2 = { 16, 4, 2 };
        Object[] scenario3 = { 8, 3, 2 };
        Object[] scenario4 = { 4, 2, 2 };
        Object[] scenario5 = { 2, 1, 2 };
        Object[] scenario6 = { 1, 0, 2 };

        return new Object[] { scenario1, scenario2, scenario3, scenario4, scenario5, scenario6 };
    }

}