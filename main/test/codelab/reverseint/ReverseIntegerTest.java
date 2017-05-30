package codelab.reverseint;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class ReverseIntegerTest {

    @Test
    @Parameters(method = "reverseParams")
    public void reverse(int expected, int number) {
        ReverseInteger reverseInteger = new ReverseInteger();
        assertEquals(expected, reverseInteger.reverse(number));
    }

    public Object[] reverseParams() {
        Object[] scenario1 = { 1234, 4321 };
        Object[] scenario2 = { 1, 1 };
        Object[] scenario3 = { 7, 7 };
        Object[] scenario4 = { 17, 71 };
        Object[] scenario5 = { 0, 2147483647 }; // int overflow
        Object[] scenario6 = { -98765, -56789 };
        Object[] scenario7 = { -808098862, -268890808 };

        return new Object[] { scenario1, scenario2, scenario3, scenario4, scenario5, scenario6, scenario7 };
    }

    @Test
    @Parameters(method = "readStackAsIntegerParams")
    public void readStackAsInteger(long expected, LinkedList<Long> linkedList) {
        ReverseInteger reverseInteger = new ReverseInteger();
        assertEquals(expected, reverseInteger.readLinkedListAsInteger(linkedList));
    }

    public Object[] readStackAsIntegerParams() {
        Object[] scenario1 = { 773L, createLinkedList(7, 7, 3) };

        return new Object[] { scenario1 };
    }

    @Test
    @Parameters(method = "pushOnTopOfLinkedListParams")
    public void pushOnTopOfLinkedList(LinkedList<Long> expected, LinkedList<Long> topList, LinkedList<Long> bottomList) {
        ReverseInteger reverseInteger = new ReverseInteger();
        LinkedList<Long> resultList = reverseInteger.pushOnTopOfLinkedList(topList, bottomList);
        assertEquals(expected.size(), resultList.size());
        while (!expected.isEmpty()) {
            assertEquals(expected.pop().intValue(), resultList.pop().intValue());
        }
    }

    public Object[] pushOnTopOfLinkedListParams() {
        LinkedList<Long> expected1 = createLinkedList(3, 2, 1, 6, 5, 4);
        LinkedList<Long> topList1 = createLinkedList(6, 5, 4);
        LinkedList<Long> bottomList1 = createLinkedList(3, 2, 1);
        Object[] scenario1 = { expected1, topList1, bottomList1 };

        return new Object[] { scenario1 };
    }

    private LinkedList<Long> createLinkedList(int... integers) {
        LinkedList<Long> linkedList = new LinkedList<>();
        for (long i : integers) {
            linkedList.push(i);
        }
        return linkedList;
    }

}