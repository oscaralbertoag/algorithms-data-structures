package leetcode.atoi;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class AtoiTest {
    @Test
    @Parameters(method = "atoiParams")
    public void myAtoi(int expected, String number) {
        Atoi atoi = new Atoi();
        assertEquals(expected, atoi.myAtoi(number));
    }

    public Object[] atoiParams() {
        Object[] scenario1 = { -2147483648, "-123456789123456" };

        return new Object[] { scenario1 };
    }

    @Test
    @Parameters(method = "powerParams")
    public void power(Long num, int power, Long expected) {
        Atoi atoi = new Atoi();
        assertEquals(expected, atoi.power(num, power));
    }

    public Object[] powerParams() {
        Object[] scenario1 = { 2L, 2, 4L };
        Object[] scenario2 = { 10L, 5, 100000L };

        return new Object[] { scenario1, scenario2 };
    }

    @Test
    @Parameters(method = "numberParams")
    public void isNumber(boolean expected, char c) {
        Atoi atoi = new Atoi();
        assertEquals(expected, atoi.isNumber(c));
    }

    public Object[] numberParams() {
        Object[] scenario0 = { true, '0' };
        Object[] scenario1 = { true, '1' };
        Object[] scenario2 = { true, '2' };
        Object[] scenario3 = { true, '3' };
        Object[] scenario4 = { true, '4' };
        Object[] scenario5 = { true, '5' };
        Object[] scenario6 = { true, '6' };
        Object[] scenario7 = { true, '7' };
        Object[] scenario8 = { true, '8' };
        Object[] scenario9 = { true, '9' };
        Object[] scenario10 = { false, 'a' };
        Object[] scenario11 = { false, 'b' };
        Object[] scenario12 = { false, 'c' };
        Object[] scenario13 = { false, 'd' };
        Object[] scenario14 = { false, '#' };

        return new Object[] { scenario0, scenario1, scenario2, scenario3, scenario4, scenario5, scenario6, scenario7, scenario8,
            scenario9, scenario10, scenario11, scenario12, scenario13, scenario14 };
    }

}