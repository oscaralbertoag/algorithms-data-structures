package codelab.reversebits;

/**
 * Reverse bits of an 32 bit unsigned integer
 *
 * Example 1:
 *
 * x = 0,
 *
 * 00000000000000000000000000000000
 * =>        00000000000000000000000000000000
 *
 * return 0
 *
 * Example 2:
 *
 * x = 3,
 *
 * 00000000000000000000000000000011
 * =>        11000000000000000000000000000000
 *
 * return 3221225472
 *
 * Since java does not have unsigned int, use long
 */
public class ReverseBits {

    public long reverse(long a) {
        String num = Long.toBinaryString(a);
        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < 32 - num.length(); i++) {
            strBuilder.append("0");
        }
        strBuilder.append(num);
        String paddedString = strBuilder.toString();
        int[] binaryNum = new int[32];

        int left;
        int right;
        for (int i = 0, j = paddedString.length() - 1; i < j; i++, j--) {
            left = paddedString.charAt(i) - '0';
            right = paddedString.charAt(j) - '0';
            binaryNum[i] = right;
            binaryNum[j] = left;
        }

        long result = 0L;
        for (int i = binaryNum.length - 1, k = 0; i >= 0; i--, k++) {
            if (binaryNum[i] == 1) {
                result += power(k, 2);
            }
        }
        return result;
    }

    protected long power(int exponent, int base) {
        if (exponent == 0) {
            return 1L;
        } else {
            return (long) base * power(exponent - 1, base);
        }
    }

    public long reverseSolution(long A) {
        long rev = 0;

        for (int i = 0; i < 32; i++) {
            rev <<= 1;
            if ((A & (1 << i)) != 0) {
                rev |= 1;
            }
        }

        return rev;

    }
}
