package codelab.integerispoweroftwo;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class IntegerPowerOfTwoTest {
    @Test
    public void power() throws Exception {
    }

    @Test
    public void toBinary() throws Exception {
    }

    @Test
    public void divide() throws Exception {
    }

    @Test
    public void subtract() throws Exception {
    }

    @Test
    @Parameters(method = "getLargerNumberParams")
    public void getLargerNumber(int[] a, int[] b, int[] expected) {
        IntegerPowerOfTwo integerPowerOfTwo = new IntegerPowerOfTwo();
        int[] largerNumber = integerPowerOfTwo.getLargerNumber(a, b);
        assertEquals(expected, largerNumber);
    }

    public Object[] getLargerNumberParams() {
        int[] a1 = { 1, 2, 3 };
        int[] b1 = { 2, 3 };
        Object[] scenario1 = { a1, b1, a1 };

        int[] a2 = { 5, 3, 5, 8, 6, 9 };
        int[] b2 = { 4, 5, 7, 3, 6, 8 };
        Object[] scenario2 = { a2, b2, a2 };

        int[] a3 = { 1, 2, 9, 8 };
        int[] b3 = { 1, 2, 9, 9 };
        Object[] scenario3 = { a3, b3, b3 };

        int[] a4 = { 5, 7, 8, 6, 0 };
        int[] b4 = { 5, 7, 8, 5, 9 };
        Object[] scenario4 = { a4, b4, a4 };

        int[] a5 = { 0 };
        int[] b5 = { 1 };
        Object[] scenario5 = { a5, b5, b5 };

        int[] a6 = { 7, 8, 4, 5, 6, 8 };
        int[] b6 = { 7, 8, 4, 5, 6, 8 };
        Object[] scenario6 = { a6, b6, a6 };

        int[] a7 = { 1, 0, 0 };
        int[] b7 = { 0, 0, 1 };
        Object[] scenario7 = { a7, b7, a7 };

        return new Object[] { scenario1, scenario2, scenario3, scenario4, scenario5, scenario6, scenario7 };
    }

}