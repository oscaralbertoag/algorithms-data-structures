package codelab.plusone;

import leetcode.divisionwithoutdivison.IntegerDivision;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Given a non-negative number represented as an array of digits,
 *
 * add 1 to the number ( increment the number represented by the digits ).
 *
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 * Example:
 *
 * If the vector has [1, 2, 3]
 *
 * the returned vector should be [1, 2, 4]
 *
 * as 123 + 1 = 124.
 *
 * NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer.
 * For example, for this problem, following are some good questions to ask :
 *
 * Q : Can the input have 0’s before the most significant digit. Or in other words, is 0 1 2 3 a valid input?
 *
 * A : For the purpose of this question, YES
 * Q : Can the output have 0’s before the most significant digit? Or in other words, is 0 1 2 4 a valid output?
 * A : For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
 */
public class PlusOne {
    public ArrayList<Integer> plusOneRecursive(ArrayList<Integer> a) {
        if (a == null || a.size() == 0) {
            return new ArrayList<>();
        } else {
            return trimLeftmostZeros(plusOneRecursive(a.size() - 1, a));
        }
    }

    private ArrayList<Integer> plusOneRecursive(int index, ArrayList<Integer> a) {
        if (a.get(index) + 1 > 9) {
            a.set(index, 0);
            if (index - 1 < 0) {
                a = addOneLeftmostDigit(a);
            } else {
                a = plusOneRecursive(index - 1, a);
            }
        } else {
            a.set(index, a.get(index) + 1);
        }
        return a;
    }

    public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
        if (a == null || a.size() == 0) {
            return new ArrayList<>();
        }
        boolean carry;
        int i = a.size() - 1;
        do {
            if (a.get(i) + 1 > 9) {
                a.set(i--, 0);
                carry = true;
            } else {
                a.set(i, a.get(i) + 1);
                carry = false;
            }
        }
        while(i >= 0 && carry);
        if (carry) {
            return addOneLeftmostDigit(a);
        } else {
            return trimLeftmostZeros(a);
        }
    }

    protected ArrayList<Integer> addOneLeftmostDigit(ArrayList<Integer> number) {
        ArrayList<Integer> newNumber = new ArrayList<>();
        newNumber.add(1);
        newNumber.addAll(number);
        return newNumber;
    }

    protected ArrayList<Integer> trimLeftmostZeros(ArrayList<Integer> number) {
        ArrayList<Integer> trimmedNumber = new ArrayList<>(number);

        Iterator<Integer> iterator = trimmedNumber.iterator();
        int n;
        boolean foundNonZeroValue = false;
        while (iterator.hasNext() && !foundNonZeroValue) {
            n = iterator.next();
            if (n == 0) {
                iterator.remove();
            } else {
                foundNonZeroValue = true;
            }
        }

        return trimmedNumber;
    }
}
