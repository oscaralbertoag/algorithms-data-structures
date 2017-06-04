package codelab.pascalsnth;

import java.util.ArrayList;

/**
 * Given an index k, return the kth row of the Pascal’s triangle.
 *
 * Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.
 *
 * Example:
 *
 * Input : k = 3
 *
 * Return : [1,3,3,1]
 *
 * NOTE : k is 0 based. k = 0, corresponds to the row [1].
 *
 * Note:Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalsNth {
    public ArrayList<Integer> getRow(int a) {
        ArrayList<Integer> zeroth = new ArrayList<>();
        zeroth.add(1);
        ArrayList<Integer> first = new ArrayList<>();
        first.add(1);
        first.add(1);

        int counter = 1;
        ArrayList<Integer> previous = first;
        ArrayList<Integer> result = new ArrayList<>();

        if (a == 0) {
            return zeroth;
        } else if (a == 1) {
            return first;
        } else {
            do {
                result.clear();
                result.add(1);
                for (int i = 1; i < previous.size(); i++) {
                    result.add(previous.get(i - 1) + previous.get(i));
                }
                result.add(1);
                previous = new ArrayList<>(result);
                counter++;
            } while (counter < a);
        }
        return result;
    }
}
