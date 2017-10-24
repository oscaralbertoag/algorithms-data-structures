package codelab.sumrootleaf;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumRootLeafTest {
    @Test
    public void sumNumbers() {
        SumRootLeaf solution = new SumRootLeaf();

        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        assertEquals(25, solution.sumNumbers(node));
    }

}