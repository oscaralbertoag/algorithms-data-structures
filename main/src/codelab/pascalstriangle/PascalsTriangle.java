package codelab.pascalstriangle;

import java.util.ArrayList;

/**
 * Given numRows, generate the first numRows of Pascal’s triangle.
 *
 * Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.
 *
 * Example:
 *
 * Given numRows = 5,
 *
 * Return
 *
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class PascalsTriangle {
    public ArrayList<ArrayList<Integer>> generate(int a) {
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
        if (a == 0) {
            return triangle;
        } else if (a == 1) {
            ArrayList<Integer> row = new ArrayList<>();
            row.add(1);
            triangle.add(row);
            return triangle;
        } else {
            triangle = generate(1);
            for (int i = 2; i <= a; i++) {
                triangle.add(nthRow(triangle, i));
            }
        }
        return triangle;
    }

    protected ArrayList<Integer> nthRow(ArrayList<ArrayList<Integer>> partialPascalTriangle, int n) {
        ArrayList<Integer> previousRow = partialPascalTriangle.get(n - 2);
        ArrayList<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 0; i < n - 2; i++) {
            row.add(previousRow.get(i) + previousRow.get(i + 1));
        }
        row.add(1);
        return row;
    }
}
