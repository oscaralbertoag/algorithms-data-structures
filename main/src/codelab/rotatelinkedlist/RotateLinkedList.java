package codelab.rotatelinkedlist;

public class RotateLinkedList {
    public ListNode rotateRight(ListNode a, int b) {
        ListNode newA = a;
        ListNode oldA = a;
        ListNode newLast;
        ListNode current = a;

        int count = b;
        int size = 1;

        while (current.next != null && count > 0) {
            current = current.next;
            count--;
            size++;
        }
        // Completed rotation
        if (count == 0) {
            newLast = current;
            while (current.next != null) {
                current = current.next;
            }
            newA = newLast.next;
            newLast.next = null;
            current.next = oldA;
        } else {
            return rotateRight(a, b % size);
        }
        return newA;
    }
}
