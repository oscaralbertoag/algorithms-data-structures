package codelab.reverseint;

import java.util.LinkedList;

/**
 * Reverse digits of an integer.
 *
 * Example1:
 *
 * x = 123,
 *
 * return 321
 * Example2:
 *
 * x = -123,
 *
 * return -321
 *
 * Return 0 if the result overflows and does not fit in a 32 bit signed integer
 */
public class ReverseInteger {

    public int reverse(int a) {
        Long result = readLinkedListAsInteger(reverseInteger(Math.abs(a)));

        boolean negative = a < 0;
        boolean overflow = result > Integer.MAX_VALUE;

        if (overflow) {
            return 0;
        } else {
            return negative ? -result.intValue() : result.intValue();
        }

    }

    protected long readLinkedListAsInteger(LinkedList<Long> linkedList) {
        long result = 0;
        if (linkedList == null) {
            return result;
        }
        int k = 1;
        while (!linkedList.isEmpty()) {
            result += k * linkedList.pop();
            k *= 10;
        }
        return result;
    }

    private LinkedList<Long> reverseInteger(long a) {
        LinkedList<Long> linkedList = new LinkedList<>();
        if (a % 10 == a) {
            linkedList.push(a);
        } else {
            linkedList.push(a % 10);
            linkedList = pushOnTopOfLinkedList(reverseInteger(a / 10), linkedList);
        }
        return linkedList;
    }

    protected LinkedList<Long> pushOnTopOfLinkedList(LinkedList<Long> topList, LinkedList<Long> bottomList) {
        LinkedList<Long> linkedList = new LinkedList<>();

        if (topList != null && bottomList != null) {
            while (!bottomList.isEmpty()) {
                linkedList.push(bottomList.removeLast());
            }
            while (!topList.isEmpty()) {
                linkedList.push(topList.removeLast());
            }
        }

        return linkedList;
    }
}
