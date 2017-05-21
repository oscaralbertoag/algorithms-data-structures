package codelab.singlenumber;

import java.util.Collections;
import java.util.List;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 *
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory? DO NOT MODIFY
 * THE ARRAY Example: Input : [1 2 2 3 1] Output : 3
 *
 *
 * Hint: Let us look at every bit position. Every number that occurs twice will either contribute 2 ‘1’s or 2 ‘0’s to the position.
 * The number that occurs once-‘X’ will contribute exactly one 0 or 1 to the position depending on whether it has 0 or 1 in that
 * position. So: If X has 1 in that position, we will have odd number of 1s in that position. If X has 0 in that position, we will
 * have odd number of 0s in that position.
 *
 * Can you think of a solution using the above observation?
 */
public class SingleNumber {
    public int singleNumberWithListModification(final List<Integer> a) {
        int singleNumber = 0;
        Collections.sort(a);
        for (int i = 0; i < a.size(); i += 2) {
            if (i + 1 >= a.size() || a.get(i).intValue() != a.get(i + 1).intValue()) {
                singleNumber = a.get(i);
                break;
            }
        }
        return singleNumber;
    }

    public int singleNumber(final List<Integer> a) {
        int zeros[] = new int[31];
        int ones[] = new int[31];
        int result[] = new int[31];
        // Initialize arrays to zero
        for (int i = 0; i < 31; i++) {
            zeros[i] = 0;
            ones[i] = 0;
            result[i] = 0;
        }

        String numInBinary;
        for (Integer num : a) {
            numInBinary = padWithZeros(31, Integer.toBinaryString(num));
            for (int j = numInBinary.length() - 1, z = 31 - 1; j >= 0; j--, z--) {
                if (numInBinary.charAt(j) == '0') {
                    zeros[z] = zeros[z] + 1;
                } else {
                    ones[z] = ones[z] + 1;
                }
            }
        }

        for (int i = 0; i < 31; i++) {
            if (zeros[i] % 2 != 0) {
                result[i] = 0;
            } else {
                result[i] = 1;
            }
        }

        return binaryToInt(result);
    }

    public int singleNumberExerciseSolution(final List<Integer> a) {
        int num = 0;

        for (int val : a) {
            num ^= val;
        }

        return num;
    }

    protected int binaryToInt(int[] a) {
        int number = 0;

        for (int i = a.length - 1, power = 0; i >= 0; i--, power++) {
            if (a[i] == 1) {
                number += power(2, power);
            }
        }

        return number;
    }

    protected int power(int num, int power) {
        if (power == 0) {
            return 1;
        } else {
            return num * power(num, power - 1);
        }
    }

    protected String padWithZeros(int size, String binaryNum) {
        StringBuilder paddedNum = new StringBuilder();

        for (int i = 0; i < size - binaryNum.length(); i++) {
            paddedNum.append("0");
        }
        paddedNum.append(binaryNum);

        return paddedNum.toString();
    }
}
