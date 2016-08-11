package algorithm;

import java.util.Arrays;

/**
 * Created by oscar on 6/14/16.
 */
public class BinarySearch {

    public static final int NOT_FOUND = -1;


    public static int find(int num, int[] array) {
        int left = 0;
        int right = array.length;
        return find(num, array, left, right);
    }

    public static int find(int num, int[] array, int left, int right) {
        int index = NOT_FOUND;
        int range = (right - left)/2;
        int middle = range + left;
        // Stopping case 1
        if (range == 1) {
            if (array[middle] == num) {
                index = middle;
            } else if(array[middle-1] == num) {
                index = middle - 1;
            }
        }
        // Stopping case 2 Found match
        else if(array[middle] == num) {
            index = middle;
        }
        // Look left
        else if (num < array[middle]) {
            return find(num, array, left, middle);
        }
        // Look right
        else if (num > array[middle]) {
            return find(num, array, middle, right);
        }
        return index;
    }
}
