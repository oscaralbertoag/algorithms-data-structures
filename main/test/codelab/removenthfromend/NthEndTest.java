package codelab.removenthfromend;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(JUnitParamsRunner.class)
public class NthEndTest {

    @Test
    @Parameters(method = "removeNthFromEndParams")
    public void removeNthFromEnd(ListNode node, int n, ListNode expected) {
        NthEnd nthEnd = new NthEnd();
        ListNode result = nthEnd.removeNthFromEnd(node, n);

        ListNode i = expected;
        ListNode j = result;
        while (i != null && j != null) {
            assertEquals(i.val, j.val);
            i = i.next;
            j = j.next;
            if ((i == null && j != null) || (i != null && j == null)) {
                fail();
            }
        }
    }

    public Object[] removeNthFromEndParams() {
        Object[] scenario1 = { listToListNode(1, 2, 3, 4, 5), 2, listToListNode(1, 2, 3, 5) };
        Object[] scenario2 = { listToListNode(1, 2, 3, 4), 4, listToListNode(2, 3, 4) };
        Object[] scenario3 = { listToListNode(1, 2, 3, 4, 5), 6, listToListNode(2, 3, 4, 5) };

        return new Object[] { scenario1, scenario2, scenario3 };
    }

    private ListNode listToListNode(int... list) {
        ListNode head = null;
        ListNode current = null;
        ListNode previous = null;
        for (int i = 0; i < list.length; i++) {
            if (i == 0) {
                head = new ListNode(list[i]);
                previous = head;
            } else {
                current = new ListNode(list[i]);
                previous.next = current;
                previous = current;
            }
        }
        return head;
    }

}