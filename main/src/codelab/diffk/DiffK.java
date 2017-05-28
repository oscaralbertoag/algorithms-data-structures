package codelab.diffk;

import java.util.ArrayList;

/**
 * Given an array ‘A’ of sorted integers and another non negative integer k, find if there exists 2 indices i and j such that A[i] -
 * A[j] = k, i != j.
 *
 * Example:
 *
 * Input :
 *
 * A : [1 3 5] k : 4
 *
 * Output : YES
 *
 * as 5 - 1 = 4
 *
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 *
 * Try doing this in less than linear space complexity.
 */
public class DiffK {
    public static final int TRUE = 1;
    public static final int FALSE = 0;

    public int diffPossible(ArrayList<Integer> a, int b) {
        int result = FALSE;
        if (a == null || a.isEmpty()) {
            return FALSE;
        }

        OUTER:
        for (int i = a.size() - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (a.get(i) - a.get(j) == b) {
                    result = TRUE;
                    break OUTER;
                } else if (a.get(i) - a.get(j) > b) {
                    break;
                }
            }
        }
        return result;
    }
}
