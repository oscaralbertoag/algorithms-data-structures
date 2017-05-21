package leetcode.divisionwithoutdivison;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class IntegerDivisionTest {

    @Test
    @Parameters(method = "divideParams")
    public void divide(int expected, int dividend, int divisor) {
        IntegerDivision integerDivision = new IntegerDivision();
        assertEquals(expected, integerDivision.divide(dividend, divisor));
    }

    public Object[] divideParams() {
        Object[] scenario1 = { 6, 24, 4 };
        Object[] scenario2 = { 1, 1, 1 };
        Object[] scenario3 = { -1, 1, -1 };
        Object[] scenario4 = { -1, -5, 5 };
        Object[] scenario5 = { 0, 1, 2 };
        Object[] scenario6 = { 10, 598, 55 };
        Object[] scenario7 = { 0, 5, 6897 };

        return new Object[] { scenario1, scenario2, scenario3, scenario4, scenario5, scenario6, scenario7 };
    }

}