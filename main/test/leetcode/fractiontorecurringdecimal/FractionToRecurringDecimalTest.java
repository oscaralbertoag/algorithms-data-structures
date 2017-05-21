package leetcode.fractiontorecurringdecimal;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class FractionToRecurringDecimalTest {

    @Test
    @Parameters(method = "fractionToDecimalParams")
    public void fractionToDecimal(String expected, int numerator, int denominator) {
        FractionToRecurringDecimal fractionToRecurringDecimal = new FractionToRecurringDecimal();
        assertEquals(expected, fractionToRecurringDecimal.fractionToDecimal(numerator, denominator));
    }

    public Object[] fractionToDecimalParams() {
        Object[] scenario1 = { "1.5", 3, 2 };
        Object[] scenario2 = { "0.(6)", 2, 3 };
        Object[] scenario3 = { "0.1(6)", 1, 6 };
        Object[] scenario4 = { "0.(001)", 1, 999 };

        return new Object[] { scenario1, scenario2, scenario3, scenario4 };
    }
}