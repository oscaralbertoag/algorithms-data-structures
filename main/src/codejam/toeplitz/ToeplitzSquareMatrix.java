package codejam.toeplitz;

/**
 * Created by oscar on 8/7/16.
 * In linear algebra, a Toeplitz matrix or diagonal-constant matrix, named after Otto
 * Toeplitz, is a matrix in which each descending diagonal from left to right is constant.
 */
public class ToeplitzSquareMatrix {

    public boolean isToeplitz(int[][] matrix) {
        int n = matrix.length;
        int previousValueDiag_1 = 0;
        int previousValueDiag_2 = 0;
        int k = 0;

        for (int h = n - 1; h >= 0; h--) {
            for (int i = 0; i <= k; i++) {
                if (i == 0) {
                    previousValueDiag_1 = matrix[h + i][i];
                    previousValueDiag_2 = matrix[i][h + i];
                } else if (previousValueDiag_1 != matrix[h + i][i] || previousValueDiag_2 != matrix[i][h + i]) {
                    return false;
                }
            }
            k++;
        }

        return true;
    }
}
