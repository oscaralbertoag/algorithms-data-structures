package codelab.rotatelinkedlist;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@RunWith(JUnitParamsRunner.class)
public class RotateLinkedListTest {
    @Test
    @Parameters(method = "rotateRightParams")
    public void rotateRight(ListNode expected, ListNode testList, int k) {
        RotateLinkedList rotate = new RotateLinkedList();

        ListNode result = rotate.rotateRight(testList, k);

        compareLists(expected, result);
    }

    public Object[] rotateRightParams() {
//        Object[] scenario1 =
//            { generateListNodes(Arrays.asList(4, 5, 1, 2, 3)), generateListNodes(Arrays.asList(1, 2, 3, 4, 5)), 2 };
        Object[] scenario2 = { generateListNodes(Arrays.asList(2, 1)), generateListNodes(Arrays.asList(1, 2)), 1 };

        return new Object[] { /*scenario1,*/ scenario2 };
    }

    public ListNode generateListNodes(List<Integer> list) {
        ListNode first = new ListNode(list.get(0));
        ListNode current = first;
        if (list.size() > 1) {
            for (int i = 1; i < list.size(); i++) {
                ListNode node = new ListNode(list.get(i));
                current.next = node;
                current = node;
            }
        }
        return first;
    }

    public void compareLists(ListNode expected, ListNode result) {
        if ((expected == null && result != null) || (expected != null && result == null)) {
            fail("One list is null while the other one is not!");
        } else if (expected != null) {
            ListNode currentExpected = expected;
            ListNode currentResult = result;
            while (currentExpected != null && currentResult != null) {
                assertEquals(currentExpected.val, currentResult.val);
                currentExpected = currentExpected.next;
                currentResult = currentResult.next;
            }
            assertTrue(currentExpected == null && currentResult == null);
        }
    }

}