package codejam.circulararrayrotation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * John Watson performs an operation called a right circular rotation on an array of integers, [a0, a1, a2, ... an-1] .
 * After performing one right circular rotation operation, the array is transformed from [a0, a1, a2, ... an-1] to
 * [an-1, a0, ... an-2].
 * <p>
 * Watson performs this operation k times. To test Sherlock's ability to identify the current element at a particular
 * position in the rotated array, Watson asks q queries, where each query consists of a single integer, m, for which you
 * must print the element at index m in the rotated array (i.e., the value of a m ).
 * <p>
 * Input format first line - n, k, q second line - The second line contains n space-separated integers, where each
 * integer i describes array element ai Each of the q subsequent lines contains a single integer denoting m.
 * <p>
 * Output Format
 * <p>
 * For each query, print the value of the element at index m of the rotated array on a new line.
 * <p>
 * Created by oscar on 8/3/16.
 */
public class CircularArrayRotation {

    private List<Integer> originalArray;
    private int[] shiftedArray;

    public CircularArrayRotation(List<Integer> array) {
        originalArray = new ArrayList<>();
        originalArray.addAll(array);
        shiftedArray = new int[originalArray.size()];
    }

    public void fillShiftedArray(int k) {
        for (int i = 0; i < originalArray.size(); i++) {
            shiftedArray[getNewIndexAfterRotation(i, k)] = originalArray.get(i);
        }
    }

    public int getNewValueAfterRotation(int index) {
        return shiftedArray[index];
    }

    protected int getNewIndexAfterRotation(int m, int k) {
        int remainder = k;
        if (remainder > originalArray.size()) {
            do {
                remainder = remainder % originalArray.size();
            } while (remainder > originalArray.size());
        }
        return shiftRight(m, remainder);
    }

    protected int shiftRight(int index, int shiftAmount) {
        if (index + shiftAmount > originalArray.size() - 1) {
            int amountOver = index + shiftAmount - (originalArray.size() - 1);
            return amountOver - 1;
        } else {
            return index + shiftAmount;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("/home/oscar/IdeaProjects/googleinterview/main/src/codejam/circulararrayrotation/input.txt"));
        int numOfNumbers = in.nextInt();
        int numOfRotations = in.nextInt();
        int numOfQueries = in.nextInt();

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < numOfNumbers; i++) {
            numbers.add(in.nextInt());
        }
        CircularArrayRotation circularArrayRotation = new CircularArrayRotation(numbers);
        circularArrayRotation.fillShiftedArray(numOfRotations);

        for (int i = 0; i < numOfQueries; i++) {
            System.out.println(circularArrayRotation.getNewValueAfterRotation(in.nextInt()));
        }
    }
}
