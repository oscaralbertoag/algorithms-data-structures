package geeksforgeeks.mergesortedarrays;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class MergeSortedArraysTest {

    @Test
    @Parameters(method = "mergeParams")
    public void merge(int[] expected, int[] a, int[] b) {
        MergeSortedArrays mergeSortedArrays = new MergeSortedArrays();
        int[] result = mergeSortedArrays.merge(a, b);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], result[i]);
        }
    }

    public Object[] mergeParams() {
        Object[] scenario1 =
            { new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, new int[] { 6, 7, 8, 9, 10 }, new int[] { 1, 2, 3, 4, 5 } };
        Object[] scenario2 = { new int[] { 1, 2, 3, 4, 5 }, new int[] { 1, 3 }, new int[] { 2, 4, 5 } };
        Object[] scenario3 = { new int[] { 1, 2, 2, 3, 5 }, new int[] { 1, 3 }, new int[] { 2, 2, 5 } };
        Object[] scenario4 = { new int[] { 1, 2, 2, 3, 5 }, new int[] { 1, 2 }, new int[] { 2, 3, 5 } };
        Object[] scenario5 = { new int[] { 1, 2, 3, 4 }, new int[] {}, new int[] { 1, 2, 3, 4 } };
        Object[] scenario6 = { new int[] { 1, 2, 2, 3, 3, 3, 3, 6, 7 }, new int[] { 1, 3, 3, 6 }, new int[] { 2, 2, 3, 3, 7 } };
        Object[] scenario7 = { new int[] {}, new int[] {}, new int[] {} };

        return new Object[] { scenario1, scenario2, scenario3, scenario4, scenario5, scenario6, scenario7 };
    }

}