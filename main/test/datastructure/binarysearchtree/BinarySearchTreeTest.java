package datastructure.binarysearchtree;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class BinarySearchTreeTest {

    @Test
    public void printPreOrderTest() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(10);
        bst.insert(6);
        bst.insert(11);
        bst.insert(7);
        bst.insert(8);
        bst.insert(4);
        bst.printPreOrder();
    }

    @Test
    public void isSubtreeTest() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(6);
        bst.insert(11);
        bst.insert(7);
        bst.insert(8);
        bst.insert(4);

        BinarySearchTree subtree = new BinarySearchTree();
        subtree.insert(6);
        subtree.insert(7);
        subtree.insert(4);
        subtree.insert(8);

        assertTrue(bst.isSubtree(bst.getRoot(), subtree.getRoot(), subtree.getRoot()));
    }

    @Test
    public void isSubtreeTest_2() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(6);
        bst.insert(11);
        bst.insert(7);
        bst.insert(8);
        bst.insert(4);

        BinarySearchTree subtree = new BinarySearchTree();
        subtree.insert(6);
        subtree.insert(7);
        subtree.insert(4);
        subtree.insert(8);
        subtree.insert(5);

        assertFalse(bst.isSubtree(bst.getRoot(), subtree.getRoot(), subtree.getRoot()));
    }

    @Test
    public void isSubtreeTest_3() {
        BinarySearchTree bst = new BinarySearchTree();
        BinarySearchTree subtree = new BinarySearchTree();
        subtree.insert(1);

        assertFalse(bst.isSubtree(bst.getRoot(), subtree.getRoot(), subtree.getRoot()));
    }

    @Test
    public void isSubtreeTest_4() {
        BinarySearchTree bst = new BinarySearchTree();
        BinarySearchTree subtree = new BinarySearchTree();
        bst.insert(1);

        assertFalse(bst.isSubtree(bst.getRoot(), subtree.getRoot(), subtree.getRoot()));
    }

    @Test
    @Parameters(method = "heightParams")
    public void heightTest(BinarySearchTree binarySearchTree, int expected) {
        assertEquals(expected, binarySearchTree.height(binarySearchTree.getRoot()));
    }

    public Object[] heightParams() {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(6);
        bst.insert(11);
        bst.insert(7);
        bst.insert(8);
        bst.insert(4);
        Object[] scenario1 = { bst, 3 };

        BinarySearchTree bst2 = new BinarySearchTree();
        bst2.insert(9);
        bst2.insert(4);
        bst2.insert(11);
        bst2.insert(8);
        bst2.insert(10);
        bst2.insert(12);
        bst2.insert(13);
        bst2.insert(5);
        bst2.insert(20);
        Object[] scenario2 = { bst2, 4 };

        return new Object[] { scenario1, scenario2 };
    }
}