package codelab.excelcolumn;

import java.util.HashMap;
import java.util.Map;

public class ExcelColumn {
    public int titleToNumber(String a) {
        Map<Character, Integer> alphabet = new HashMap<>();
        int alphabetCount = (int) 'A';
        for (int i = 1; i <= 26; i++) {
            alphabet.put((char) alphabetCount++, i);
        }
        int column = 0;
        int exponent = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            column += alphabet.get(a.charAt(i)) * power(26, exponent++);
        }
        return column;
    }

    protected int power(int base, int exponent) {
        if (exponent > 0) {
            return base * power(base, exponent - 1);
        } else {
            return 1;
        }
    }
}
