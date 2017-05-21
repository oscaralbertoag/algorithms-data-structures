package leetcode.atoi;

public class Atoi {
    public int myAtoi(String str) {
        if (str == null || str.equals("")) {
            return 0;
        }
        boolean negativeNum = false;
        Long number = 0L;
        int power = 0;
        char previous = str.charAt(0);

        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (c != ' ') {
                if (!isNumber(previous)) {
                    number = 0L;
                    power = 0;
                    negativeNum = false;
                }
                if (c == '-') {
                    negativeNum = true;
                } else if (c == '+') {
                    negativeNum = false;
                } else {
                    number += (c - '0') * power(10L, power++);
                }
            }
            previous = c;
        }
        if (number > Integer.MAX_VALUE) {
            return negativeNum ? -Integer.MAX_VALUE : Integer.MAX_VALUE;
        } else {
            return negativeNum ? -number.intValue() : number.intValue();
        }
    }

    protected Long power(Long number, int power) {
        if (power == 0) {
            return 1L;
        } else {
            return number * power(number, power - 1);
        }
    }

    protected boolean isNumber(char c) {
        return c > 47 && c < 58;
    }
}
