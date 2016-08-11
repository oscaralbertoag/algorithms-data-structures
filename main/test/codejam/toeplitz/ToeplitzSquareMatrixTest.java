package codejam.toeplitz;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by oscar on 8/7/16.
 */
public class ToeplitzSquareMatrixTest {

    @Test
    public void isToeplitzTest_success() {
        int[] row_0 = {1,3,6,7};
        int[] row_1 = {2,1,3,6};
        int[] row_2 = {5,2,1,3};
        int[] row_3 = {8,5,2,1};
        int[][] matrix = {row_0, row_1, row_2, row_3};
        ToeplitzSquareMatrix toeplitzSquareMatrix = new ToeplitzSquareMatrix();

        assertTrue(toeplitzSquareMatrix.isToeplitz(matrix));

    }

    @Test
    public void isToeplitzTest_success_2() {
        int[] row_0 = {1,3,6,7,9};
        int[] row_1 = {2,1,3,6,7};
        int[] row_2 = {5,2,1,3,6};
        int[] row_3 = {8,5,2,1,3};
        int[] row_4 = {2,8,5,2,1};
        int[][] matrix = {row_0, row_1, row_2, row_3, row_4};
        ToeplitzSquareMatrix toeplitzSquareMatrix = new ToeplitzSquareMatrix();

        assertTrue(toeplitzSquareMatrix.isToeplitz(matrix));

    }

    @Test
    public void isToeplitzTest_fail() {
        int[] row_0 = {1,3,6,7};
        int[] row_1 = {2,1,3,5};
        int[] row_2 = {5,2,1,3};
        int[] row_3 = {8,5,2,1};
        int[][] matrix = {row_0, row_1, row_2, row_3};
        ToeplitzSquareMatrix toeplitzSquareMatrix = new ToeplitzSquareMatrix();

        assertFalse(toeplitzSquareMatrix.isToeplitz(matrix));

    }


    @Test
    public void isToeplitzTest_fail_2() {
        int[] row_0 = {1,3,6,7};
        int[] row_1 = {5,1,3,6};
        int[] row_2 = {5,2,1,3};
        int[] row_3 = {8,5,2,1};
        int[][] matrix = {row_0, row_1, row_2, row_3};
        ToeplitzSquareMatrix toeplitzSquareMatrix = new ToeplitzSquareMatrix();

        assertFalse(toeplitzSquareMatrix.isToeplitz(matrix));

    }

}