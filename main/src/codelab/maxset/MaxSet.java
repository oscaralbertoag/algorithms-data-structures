package codelab.maxset;

import java.util.ArrayList;
import java.util.List;

/**
 * Find out the maximum sub-array of non negative numbers from an array. The sub-array should be continuous. That is, a sub-array
 * created by choosing the second and fourth element and skipping the third element is invalid.
 *
 * Maximum sub-array is defined in terms of the sum of the elements in the sub-array. Sub-array A is greater than sub-array B if
 * sum(A) > sum(B).
 *
 * Example:
 *
 * A : [1, 2, 5, -7, 2, 3] The two sub-arrays are [1, 2, 5] [2, 3]. The answer is [1, 2, 5] as its sum is larger than [2, 3]
 *
 * NOTE: If there is a tie, then compare with segment's length and return segment which has maximum length NOTE 2: If there is still
 * a tie, then return the segment with minimum starting index
 */
public class MaxSet {

    public ArrayList<Integer> maxset(List<Integer> a) {
        if (a == null || a.isEmpty()) {
            return new ArrayList<>();
        }

        ArrayList<Integer> maxSubArray = new ArrayList<>();
        ArrayList<Integer> currentSubArray = new ArrayList<>();

        long maxSum = 0;
        int maxSubArrayStartIndex = Integer.MAX_VALUE;
        int maxLength = 0;
        long currentSum = 0;
        int currentSubArrayStartIndex;
        int currentLength = 0;

        int current;
        for (int i = 0; i < a.size(); i++) {
            current = a.get(i);
            if (current >= 0) {
                currentSubArrayStartIndex = i;
                while (current >= 0) {
                    currentSubArray.add(current);
                    currentSum += current;
                    if (i + 1 < a.size()) {
                        current = a.get(++i);
                    } else {
                        break;
                    }
                }
                currentLength = currentSubArray.size();
                // Compare to max
                boolean currentSumIsGreater = currentSum > maxSum;
                boolean equalSumAndCurrentLengthIsGreater = currentSum == maxSum && currentLength > maxLength;
                boolean minStartIndexAllElseEqual =
                    currentSum == maxSum && currentLength == maxLength && currentSubArrayStartIndex < maxSubArrayStartIndex;
                if (currentSumIsGreater || equalSumAndCurrentLengthIsGreater || minStartIndexAllElseEqual) {
                    maxSum = currentSum;
                    currentSum = 0;
                    maxLength = currentLength;
                    maxSubArrayStartIndex = currentSubArrayStartIndex;
                    maxSubArray = currentSubArray;
                    currentSubArray = new ArrayList<>();
                } else {
                    currentSum = 0;
                    currentSubArray.clear();
                }
            }
        }
        return maxSubArray;
    }
}
