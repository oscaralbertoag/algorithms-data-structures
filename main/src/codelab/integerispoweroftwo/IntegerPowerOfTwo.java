package codelab.integerispoweroftwo;

/**
 * Find if Given number is power of 2 or not.
 * More specifically, find if given number can be expressed as 2^k where k >= 1.
 *
 * Input:
 *
 * number length can be more than 64, which mean number can be greater than 2 ^ 64 (out of long long range)
 *
 * Output:
 *
 * return 1 if the number if a power of 2 else return 0
 *
 * Example:
 *
 * Input : 128
 * Output : 1
 */
public class IntegerPowerOfTwo {
    public int power(String a) {
        if (a == null || a.length() == 0) {
            return 0;
        }

        int l = 0;
        int r = a.length() - 1;
        int count;
        while (l < r) {

        }
        return 0;
    }

    public String toBinary(String integer) {
        return null;
    }

    protected int[] divide(int[] dividend, int[] divisor) {
        int[] result = new int[dividend.length];
        if (divisor.length == 1 && divisor[0] == 0) {
            return result;
        }

        return result;
    }

    protected int[] subtract(int[] a, int[] b) {
        int[] result = new int[a.length];

        return result;
    }

    protected int[] getLargerNumber(int[] a, int[] b) {
        int[] result = a;
        if (a.length > b.length) {
            result = a;
        } else if (b.length > a.length) {
            result = b;
        } else {
            int index = 0;
            while (index < a.length) {
                if (a[index] > b[index]) {
                    return a;
                } else if (b[index] > a[index]) {
                    return b;
                }
                index++;
            }
        }
        return result;
    }
}
