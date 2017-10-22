package codelab.orderofoperations;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class OrderOfOperationsTest {

    @Test
    @Parameters(method = "parseExpressionParams")
    public void parseExpressionTest(int expected, String expression) {
        OrderOfOperations solution = new OrderOfOperations();
        assertEquals(expected, solution.evaluateExpression(expression));
    }

    public Object parseExpressionParams() {
        Object[] scenario1 = { 4, "2 + 2" };
        Object[] scenario2 = { 11, "8 - 3 + 6" };
        Object[] scenario3 = { 5, "2*4 + 1 - 8/2" };
        Object[] scenario4 = { -3, "1 + 2 + 6 - 7*2 + 2" };
        Object[] scenario5 = { 6, "3 - 2 - 1 - 4 + 10" };
        Object[] scenario6 = { 48, "24 + 24" };

        return new Object[] { scenario1, scenario2, scenario3, scenario4, scenario5, scenario6 };
    }

    @Test
    @Parameters(method = "performOperationParams")
    public void performOperationTest(int expected, char operator, String leftOperand, String rightOperand) {
        OrderOfOperations solution = new OrderOfOperations();
        assertEquals(expected, solution.performOperation(operator, leftOperand, rightOperand));
    }

    public Object[] performOperationParams() {
        Object[] scenario1 = { 10, '*', "2", "5" };
        Object[] scenario2 = { 5, '/', "30", "6" };
        Object[] scenario3 = { 58, '+', "12", "46" };
        Object[] scenario4 = { 7, '-', "10", "3" };

        return new Object[] { scenario1, scenario2, scenario3, scenario4 };
    }

    @Test
    @Parameters(method = "extractNumberParams")
    public void extractNumberTest(String expression, int index, String expected) {
        OrderOfOperations solution = new OrderOfOperations();
        assertEquals(expected, solution.extractNumber(expression, index));
    }

    public Object[] extractNumberParams() {
        Object[] scenario1 = { "2 + 34 ", 4, "34" };
        Object[] scenario2 = { " 2 -3 ", 1, "2" };
        Object[] scenario3 = { " 1+5", 3, "5" };
        Object[] scenario4 = { " 1234 + 23", 1, "1234" };
        Object[] scenario5 = { "1 - 2", 2, "" };

        return new Object[] { scenario1, scenario2, scenario3, scenario4, scenario5 };
    }
}