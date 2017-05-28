package codelab.symmetry;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class SymmetryTest {
    @Test
    @Parameters(method = "symmetricParams")
    public void isSymmetric(int expected, TreeNode a) {
        Symmetry symmetry = new Symmetry();
        assertEquals(expected, symmetry.isSymmetric(a));
    }

    @Test
    @Parameters(method = "symmetricParams")
    public void isSymmetricSolutionTest(int expected, TreeNode a) {
        Symmetry symmetry = new Symmetry();
        assertEquals(expected, symmetry.isSymmetricSolution(a));
    }

    public Object[] symmetricParams() {
        Object[] scenario1 = { 1, anySymmetricTree() };
        Object[] scenario2 = { 0, anyAsymmetricTree() };
        Object[] scenario3 = { 1, anySymmetricTreeMissingNodes() };
        Object[] scenario4 = { 0, anyAsymmetricTreeMissingNodes() };
        Object[] scenario5 = { 0, anyAsymmetricTreeMissingLeftNodes() };
        Object[] scenario6 = { 1, new TreeNode(1) };
        Object[] sceanrio7 = { 1, anySymmetricTree2() };

        return new Object[] { scenario1, scenario2, scenario3, scenario4, scenario5, scenario6, sceanrio7 };
    }

    @Test
    public void inOrderTest() {
        Symmetry symmetry = new Symmetry();
        List<Integer> integers = symmetry.inOrder(anySymmetricTree());
        List<Integer> expected = Arrays.asList(3, 2, 4, 1, 4, 2, 3);

        assertEquals(expected.size(), integers.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), integers.get(i));
        }
    }

    @Test
    public void heightTest() {
        Symmetry symmetry = new Symmetry();
        assertEquals(2, symmetry.height(anySymmetricTree()));
    }

    @Test
    public void traverseByLevelTest() {
        Symmetry symmetry = new Symmetry();
        List<Integer> expected = Arrays.asList(1, 2, 2, 3, 4, 4, 3);
        List<Integer> byLevel = symmetry.traverseByLevel(anySymmetricTree());
        assertEquals(expected.size(), byLevel.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), byLevel.get(i));
        }
    }

    private TreeNode anySymmetricTree() {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode(4);
        tree.right = new TreeNode(2);
        tree.right.left = new TreeNode(4);
        tree.right.right = new TreeNode(3);
        return tree;
    }

    private TreeNode anySymmetricTree2() {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(2);
        return node;
    }

    private TreeNode anySymmetricTreeMissingNodes() {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(2);
        tree.left.left = new TreeNode(3);
        tree.right.right = new TreeNode(3);
        return tree;
    }

    private TreeNode anyAsymmetricTree() {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode(4);
        tree.right = new TreeNode(2);
        tree.right.left = new TreeNode(3);
        tree.right.right = new TreeNode(4);
        return tree;
    }

    private TreeNode anyAsymmetricTreeMissingNodes() {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(2);
        tree.left.left = new TreeNode(3);
        tree.right.left = new TreeNode(3);
        return tree;
    }

    private TreeNode anyAsymmetricTreeMissingLeftNodes() {
        TreeNode tree = new TreeNode(1);
        tree.right = new TreeNode(2);
        tree.right.right = new TreeNode(3);
        return tree;
    }

}