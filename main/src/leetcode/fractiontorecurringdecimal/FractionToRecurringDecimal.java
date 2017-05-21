package leetcode.fractiontorecurringdecimal;

import java.util.ArrayList;
import java.util.List;

public class FractionToRecurringDecimal {
    public static final int PRECISION = 50;

    public String fractionToDecimal(int numerator, int denominator) {
        // TODO Fix failing test cases
        int integerPart = numerator / denominator;
        int remainder = numerator % denominator;
        List<Integer> decimals = new ArrayList<>();

        boolean repeating = false;
        int count = 0;
        int indexOfRepeatingSequence = 0;
        while (remainder != 0 || count > PRECISION) {
            remainder *= 10;
            if (remainder < denominator) {
                decimals.add(remainder / denominator);
                indexOfRepeatingSequence = ++count;
                repeating = true;
            } else if (!decimals.contains(remainder / denominator)) {
                decimals.add(remainder / denominator);
                count++;
            } else {
                repeating = true;
                break;
            }
            remainder = remainder % denominator;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(integerPart);
        sb.append(".");
        for (int i = 0; i < decimals.size(); i++) {
            if (repeating && i == indexOfRepeatingSequence) {
                sb.append("(");
            }
            sb.append(decimals.get(i));
        }
        if (repeating) {
            sb.append(")");
        }
        return sb.toString();
    }
}
