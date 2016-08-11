package datastructure.binarysearchtree;

import algorithm.BinarySearch;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by oscar on 8/7/16.
 */
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
}