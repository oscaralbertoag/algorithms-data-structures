package codelab.removenthfromend;

import java.util.LinkedList;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 *
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 * Note:
 * If n is greater than the size of the list, remove the first node of the list.
 *
 * Try doing it using constant additional space.
 */
public class NthEnd {
    public ListNode removeNthFromEnd(ListNode a, int b) {
        LinkedList<ListNode> linkedList = new LinkedList<>();
        ListNode current = a;
        while (current != null) {
            addToListOfNodes(linkedList, current, b);
            current = current.next;
        }
        if (b >= linkedList.size()) {
            return a.next;
        } else {
            remove(linkedList.getFirst());
            return a;
        }
    }

    private void addToListOfNodes(LinkedList<ListNode> linkedList, ListNode current, int b) {
        linkedList.add(current);
        if (linkedList.size() > b + 1) {
            linkedList.removeFirst();
        }
    }

    private void remove(ListNode node) {
        ListNode nodeToRemove = node.next;
        node.next = nodeToRemove.next;
    }

}
