package codejam.binarynumbers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by oscar on 7/29/16.
 */
public class BinaryNumbersTest {

    @Test
    public void generateTest() {
        BinaryNumbers binaryNumbersUnderTest = new BinaryNumbers();
        String[] results = binaryNumbersUnderTest.generate(3, true);

        String[] expected = {"000", "001", "010", "011", "100", "101", "110", "111"};

        assertEquals(8, results.length);
        assertNotEquals(results, expected);
        for(int i=0; i<expected.length; i++) {
            assertEquals(results[i], expected[i]);
        }
    }

    @Test
    public void powerTest() {
        BinaryNumbers binaryNumbersUnderTest = new BinaryNumbers();
        assertEquals(1, binaryNumbersUnderTest.power(2,0));
        assertEquals(2, binaryNumbersUnderTest.power(2,1));
        assertEquals(4, binaryNumbersUnderTest.power(2,2));
        assertEquals(8, binaryNumbersUnderTest.power(2,3));
        assertEquals(16, binaryNumbersUnderTest.power(2,4));
        assertEquals(32, binaryNumbersUnderTest.power(2,5));
        assertEquals(64, binaryNumbersUnderTest.power(2,6));
        assertEquals(128, binaryNumbersUnderTest.power(2,7));
        assertEquals(256, binaryNumbersUnderTest.power(2,8));
        assertEquals(512, binaryNumbersUnderTest.power(2,9));
        assertEquals(1024, binaryNumbersUnderTest.power(2,10));
    }

}