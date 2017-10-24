package codelab.sumrootleaf;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 *
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 *
 * Find the total sum of all root-to-leaf numbers % 1003.
 *
 * Example :
 *
 * 1 / \ 2   3
 *
 * The root-to-leaf path 1->2 represents the number 12. The root-to-leaf path 1->3 represents the number 13.
 *
 * Return the sum = (12 + 13) % 1003 = 25 % 1003 = 25.
 */
public class SumRootLeaf {
    public int sumNumbers(TreeNode a) {
        List<String> numbers = extractNumbers(a);

        BigInteger sum = BigInteger.ZERO;
        for (String number : numbers) {
            sum = sum.add(new BigInteger(number));
        }
        BigInteger mod = sum.mod(new BigInteger("1003"));
        return mod.intValue();
    }

    private List<String> extractNumbers(TreeNode a) {
        List<String> results = new ArrayList<>();

        if (a != null) {
            String currentDigit = String.valueOf(a.val);

            List<String> left = extractNumbers(a.left);
            for (String number : left) {
                results.add(currentDigit + number);
            }
            List<String> right = extractNumbers(a.right);
            for (String number : right) {
                results.add(currentDigit + number);
            }
            if (results.isEmpty()) {
                results.add(currentDigit);
            }
        }
        return results;
    }
}
