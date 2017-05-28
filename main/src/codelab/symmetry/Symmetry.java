package codelab.symmetry;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * Example :
 *
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 *
 * The above binary tree is symmetric.
 * But the following is not:
 *
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 *
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class Symmetry {
    private static final int SYMMETRIC = 1;
    private static final int ASYMMETRIC = 0;

    public int isSymmetric(TreeNode a) {
        int result = SYMMETRIC;
        int height = height(a);
        List<Integer> currentLevel = new ArrayList<>();
        // Skip first level
        OUTER_LOOP:
        for (int i = 2; i <= height + 1; i++) {
            currentLevel.clear();
            currentLevel.addAll(printLevel(a, i));
            for (int j = 0, k = currentLevel.size() - 1; k > j; j++, k--) {
                if (currentLevel.get(j) == null && currentLevel.get(k) == null) {
                    result = SYMMETRIC;
                } else if ((currentLevel.get(j) == null && currentLevel.get(k) != null) || (currentLevel.get(j) != null
                    && currentLevel.get(k) == null) || currentLevel.get(j).intValue() != currentLevel.get(k).intValue()) {
                    result = ASYMMETRIC;
                    break OUTER_LOOP;
                }
            }
        }
        return result;
    }

    protected List<Integer> inOrder(TreeNode a) {
        List<Integer> inOrder = new ArrayList<>();
        if (a != null) {
            inOrder.addAll(inOrder(a.left));
            inOrder.add(a.val);
            inOrder.addAll(inOrder(a.right));
        }
        return inOrder;
    }

    protected int height(TreeNode a) {
        if (a == null || (a.left == null && a.right == null)) {
            return 0;
        } else {
            int left = height(a.left);
            int right = height(a.right);
            return 1 + ((left > right) ? left : right);
        }
    }

    protected List<Integer> printLevel(TreeNode a, int level) {
        List<Integer> numbers = new ArrayList<>();
        if (a != null) {
            if (level == 1) {
                numbers.add(a.val);
            } else {
                numbers.addAll(printLevel(a.left, level - 1));
                numbers.addAll(printLevel(a.right, level - 1));
            }
        } else {
            numbers.add(null); // Account for missing nodes
        }
        return numbers;
    }

    protected List<Integer> traverseByLevel(TreeNode a) {
        List<Integer> currentLevel = new ArrayList<>();
        int height = height(a);
        for (int i = 1; i <= height + 1; i++) {
            currentLevel.addAll(printLevel(a, i));
        }
        return currentLevel;
    }

    public int isSymmetricSolution(TreeNode A) {

        if (A == null) {
            return 0;
        }

        return rec(A.left, A.right) ? 1 : 0;

    }

    public boolean rec(TreeNode node1, TreeNode node2) {

        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null) {
            return false;
        }

        if (node1.val != node2.val) {
            return false;
        }

        return rec(node1.left, node2.right) | rec(node1.right, node2.left);

    }
}
