package technicalassessments.rotatedarray;

/**
 * Given a sorted array of integers that has been rotated by k places, write a function that given number i finds it in the array
 * and returns its index. For example:
 * array -> [4,5,6,1,2,3]
 * find -> i=2
 * result -> index=4
 *
 * Can you use the fact that the array is sorted to find it faster?
 */
public class RotatedArray {
    private static final int NOT_FOUND = -1;
    private int counter = 0;

    public int find(int[] array, int numberToFind) {
        if (array != null && array.length > 0) {
            return find(array, 0, numberToFind);
        } else {
            return NOT_FOUND;
        }
    }

    private int find(int[] array, int index, int i) {
        if (counter < array.length - 1) {
            counter++;
            if (array[index] == i) {
                return index;
            } else if (array[index] > i) {
                if (index == 0) {

                    return find(array, array.length - 1, i);
                } else {
                    return find(array, index - 1, i);
                }
            } else if (array[index] < i) {
                if (index == array.length - 1) {
                    return find(array, 0, i);
                } else {
                    return find(array, index + 1, i);
                }
            }
        }
        return NOT_FOUND;
    }
}
