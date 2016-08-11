package algorithm;

import java.util.Arrays;

/**
 * Created by oscar on 6/15/16.
 */
public class Merge {

    public static int[] sort(int[] array) {

        int middle = array.length / 2;
        int[] leftArray;
        int[] rightArray;

        // Stopping case: Only 1-element array
        if (middle == 0) {
            return array;
        } else {
            // Split left
            leftArray = sort(Arrays.copyOfRange(array, 0, middle));
            // Split right
            rightArray = sort(Arrays.copyOfRange(array, middle, array.length));
            // Merge them
            return merge(leftArray, rightArray);
        }

    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];

        int resultIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        while ((leftIndex + rightIndex) < result.length) {
            if (leftIndex >= left.length){ // We've reached the end of left array
                result[resultIndex++] = right[rightIndex++];
            } else if(rightIndex >= right.length) { // We've reached the end of the right array
                result[resultIndex++] = left[leftIndex++];
            } else if (left[leftIndex] < right[rightIndex]) {
                result[resultIndex++] = left[leftIndex++];
            } else if(left[leftIndex] > right[rightIndex]) {
                result[resultIndex++] = right[rightIndex++];
            } else if (left[leftIndex] == right[rightIndex]) {
                result[resultIndex++] = left[leftIndex++];
                result[resultIndex++] = right[rightIndex++];
            }
        }

        return result;
    }
}
