package leetcode.reverselinkedlist;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class SinglyLinkedListTest {
    @Test
    public void addNothingTest() {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        assertNull(linkedList.getHead());
        assertNull(linkedList.getTail());
        assertEquals(0, linkedList.getSize());
        // Reverse
        linkedList.reverse();
        assertNull(linkedList.getHead());
        assertNull(linkedList.getTail());
        assertEquals(0, linkedList.getSize());
        // Print
        linkedList.print();
    }

    @Test
    public void addOne() {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.add(1);
        assertEquals(1, linkedList.getSize());
        assertNotNull(linkedList.getHead());
        assertNotNull(linkedList.getTail());
        assertEquals(1, linkedList.getHead().getValue());
        assertEquals(1, linkedList.getTail().getValue());
        // Reverse
        linkedList.reverse();
        assertEquals(1, linkedList.getSize());
        assertNotNull(linkedList.getHead());
        assertNotNull(linkedList.getTail());
        assertEquals(1, linkedList.getHead().getValue());
        assertEquals(1, linkedList.getTail().getValue());
        // Print
        linkedList.print();
    }

    @Test
    public void addTest() {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(4);
        assertEquals(3, linkedList.getSize());
        assertNotNull(linkedList.getHead());
        assertNotNull(linkedList.getTail());
        assertEquals(1, linkedList.getHead().getValue());
        assertEquals(4, linkedList.getTail().getValue());
        linkedList.print();
    }

    @Test
    public void reverseTest() {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(5);
        assertEquals(4, linkedList.getSize());
        assertNotNull(linkedList.getHead());
        assertNotNull(linkedList.getTail());
        assertEquals(1, linkedList.getHead().getValue());
        assertEquals(5, linkedList.getTail().getValue());

        int[] linkedListArray = linkedList.toArray();
        List<Integer> expected = Arrays.asList(1, 2, 3, 5);
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i).intValue(), linkedListArray[i]);
        }
        // Print
        linkedList.print();

        // Reverse linked list
        linkedList.reverse();
        assertEquals(4, linkedList.getSize());
        assertNotNull(linkedList.getHead());
        assertNotNull(linkedList.getTail());
        assertEquals(5, linkedList.getHead().getValue());
        assertEquals(1, linkedList.getTail().getValue());

        int[] linkedListReversedArray = linkedList.toArray();
        List<Integer> expectedReversed = Arrays.asList(5, 3, 2, 1);
        for (int i = 0; i < expectedReversed.size(); i++) {
            assertEquals(expectedReversed.get(i).intValue(), linkedListReversedArray[i]);
        }
        //Print
        linkedList.print();
    }

}