package leetcode.divisionwithoutdivison;

/**
 * Perform integer division without using multiplication, division, or mod operations
 */
public class IntegerDivision {
    public int divide(int dividend, int divisor) {
        if (divisor == 0 || dividend == 0 || Math.abs(dividend) - Math.abs(divisor) < 0) {
            return 0;
        }

        int dividendAbs = Math.abs(dividend);
        int divisorAbs = Math.abs(divisor);
        boolean dividendIsNegative = dividend != dividendAbs;
        boolean divisorIsNegative = divisor != divisorAbs;
        boolean negative = (dividendIsNegative && !divisorIsNegative) || (!dividendIsNegative && divisorIsNegative);

        int a = divisorAbs;
        int resultCount = 1;

        while (dividendAbs - a > divisorAbs) {
            a += divisorAbs;
            resultCount++;
        }

        if (dividendAbs - a == divisorAbs) {
            resultCount++;
        }

        return negative ? -resultCount : resultCount;

    }
}
