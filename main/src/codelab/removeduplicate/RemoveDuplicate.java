package codelab.removeduplicate;

import java.util.ArrayList;

/**
 * Remove duplicates from Sorted Array
 * Given a sorted array, remove the duplicates in place such that each element appears only once and return the new length.
 *
 * Note that even though we want you to return the new length, make sure to change the original array as well in place
 *
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 *
 * Example:
 * Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 */
public class RemoveDuplicate {
    public int removeDuplicates(ArrayList<Integer> a) {
        int x;
        for (int i = 0, j = 1; i < a.size() || j < a.size(); i++, j++) {
            x = a.get(i);
            while (j < a.size() && a.get(j) == x) {
                a.remove(j);
            }
        }
        return a.size();
    }

    public int removeDuplicatesEfficient(ArrayList<Integer> a) {
        // TODO
        return 0;
    }
}
