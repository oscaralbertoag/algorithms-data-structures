package algorithm.quicksort;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by oscar on 7/16/16.
 */
public class QuicksortTest {

    @Test
    public void testSort_empty() {
        int[] testArray = new int[0];
        Quicksort quicksortUnderTest = new Quicksort(testArray);
        int[] result = quicksortUnderTest.sort();
        assertEquals(0, result.length);
    }

    @Test
    public void testSort_noDuplicates() {
        int[] testArray = {2, 5, 4, 7, 6, 8, 9, 1, 3, 0};
        Quicksort quicksortUnderTest = new Quicksort(testArray);
        int[] result = quicksortUnderTest.sort();

        int[] expected = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        assertNotEquals(testArray, result);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], result[i]);
        }
    }

    @Test
    public void testSort_noDuplicates2() {
        int[] testArray = {0, 4, 7, 6, 1, 2, 3};
        Quicksort quicksortUnderTest = new Quicksort(testArray);
        int[] result = quicksortUnderTest.sort();

        int[] expected = {0, 1, 2, 3, 4, 6, 7};

        assertNotEquals(testArray, result);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], result[i]);
        }
    }

    @Test
    public void testSort_duplicates() {
        int[] testArray = {2, 5, 4, 7, 6, 8, 9, 1, 2, 3, 0};
        Quicksort quicksortUnderTest = new Quicksort(testArray);
        int[] result = quicksortUnderTest.sort();

        int[] expected = {0, 1, 2, 2, 3, 4, 5, 6, 7, 8, 9};

        assertNotEquals(testArray, result);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], result[i]);
        }
    }

    @Test
    public void testSort_duplicates2() {
        int[] testArray = {2, 0, 5, 4, 7, 6, 7, 8, 9, 1, 2, 3, 0, 9};
        Quicksort quicksortUnderTest = new Quicksort(testArray);
        int[] result = quicksortUnderTest.sort();

        int[] expected = {0, 0, 1, 2, 2, 3, 4, 5, 6, 7, 7, 8, 9, 9};

        assertNotEquals(testArray, result);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], result[i]);
        }
    }

    @Test
    public void testShiftRight_clearFirstPosition() {
        int[] testArray = new int[5];
        testArray[0] = 1;
        testArray[1] = 2;
        testArray[2] = 3;
        testArray[3] = 4;

        Quicksort quicksortUnderTest = new Quicksort(testArray);
        quicksortUnderTest.shiftRight(0, 4, -1);
        int[] result = quicksortUnderTest.getArray();
        assertEquals(5, result.length);
        assertEquals(-1, result[0]);
        assertEquals(1, result[1]);
        assertEquals(2, result[2]);
        assertEquals(3, result[3]);
        assertEquals(4, result[4]);
    }

    @Test
    public void testShiftRight_outOfRange() {
        int[] testArray = {1, 2, 3, 4, 5};

        Quicksort quicksortUnderTest = new Quicksort(testArray);
        quicksortUnderTest.shiftRight(0, 5, -1);
        int[] result = quicksortUnderTest.getArray();
        assertEquals(testArray[0], result[0]);
        assertEquals(testArray[1], result[1]);
        assertEquals(testArray[2], result[2]);
        assertEquals(testArray[3], result[3]);
        assertEquals(testArray[4], result[4]);
    }

    @Test
    public void testShiftRight_clearMiddlePosition() {
        int[] testArray = new int[7];
        testArray[0] = 1;
        testArray[1] = 2;
        testArray[2] = 3;
        testArray[3] = 4;
        testArray[4] = 5;
        testArray[5] = 6;
        testArray[6] = 7;

        Quicksort quicksortUnderTest = new Quicksort(testArray);
        quicksortUnderTest.shiftRight(2, 5, -1);
        int[] result = quicksortUnderTest.getArray();
        assertEquals(7, result.length);
        assertEquals(1, result[0]);
        assertEquals(2, result[1]);
        assertEquals(-1, result[2]);
        assertEquals(3, result[3]);
        assertEquals(4, result[4]);
        assertEquals(5, result[5]);
        assertEquals(7, result[6]);
    }
}