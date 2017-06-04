package geeksforgeeks.rotatesquarematrix;

public class RotateSquareMatrix {

    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println("-----------------------");
    }

    public void rotate90DegreesCounterClockwise(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            int count = matrix[i].length - 1 - i;
            for (int j = i; j < matrix[i].length - 1 - i; j++) {
                // right column
                int rightX = j;
                int rightY = matrix[i].length - 1 - i;
                // bottom column
                int bottomX = matrix[i].length - 1 - i;
                int bottomY = count;
                // left column
                int leftX = count;
                int leftY = i;

                // Swap
                int topValue = matrix[i][j];
                int rightValue = matrix[rightX][rightY];
                int bottomValue = matrix[bottomX][bottomY];
                int leftValue = matrix[leftX][leftY];
                matrix[i][j] = rightValue;
                matrix[rightX][rightY] = bottomValue;
                matrix[bottomX][bottomY] = leftValue;
                matrix[leftX][leftY] = topValue;
                count--;
            }
        }
    }

    public static void main(String[] args) {
        RotateSquareMatrix rotateSquareMatrix = new RotateSquareMatrix();
        int[][] matrix = new int[4][4];
        matrix[0] = new int[] { 1, 2, 3, 4 };
        matrix[1] = new int[] { 5, 6, 7, 8 };
        matrix[2] = new int[] { 9, 10, 11, 12 };
        matrix[3] = new int[] { 13, 14, 15, 16 };

        rotateSquareMatrix.rotate90DegreesCounterClockwise(matrix);
        rotateSquareMatrix.printMatrix(matrix);
    }
}
