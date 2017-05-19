package codelab;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SingleNumberTest {

    @Test
    public void singleNumberTest() {
        SingleNumber singleNumber = new SingleNumber();
        List<Integer> testList = Arrays
            .asList(723, 256, 668, 723, 140, 360, 597, 233, 128, 845, 737, 804, 986, 701, 906, 512, 845, 510, 510, 227, 430, 701,
                366, 946, 464, 619, 946, 627, 209, 771, 424, 555, 959, 711, 530, 937, 716, 261, 505, 658, 706, 140, 511, 277, 396,
                233, 819, 196, 475, 906, 583, 261, 147, 658, 517, 197, 196, 702, 944, 711, 128, 555, 149, 483, 530, 291, 716, 258,
                430, 464, 601, 749, 149, 415, 802, 573, 627, 771, 660, 601, 360, 986, 291, 51, 415, 51, 227, 258, 937, 366, 923,
                669, 33, 517, 417, 702, 475, 706, 110, 417, 275, 804, 500, 473, 746, 973, 669, 275, 973, 147, 817, 657, 277, 923,
                144, 660, 197, 511, 793, 893, 944, 505, 322, 817, 586, 512, 322, 668, 33, 424, 962, 597, 144, 746, 345, 753, 345,
                269, 819, 483, 368, 802, 573, 962, 583, 615, 208, 209, 269, 749, 256, 657, 619, 893, 959, 473, 753, 299, 396, 299,
                500, 368, 586, 110, 793, 737, 615);

        assertEquals(208, singleNumber.singleNumberExerciseSolution(testList));
        assertEquals(208, singleNumber.singleNumber(testList));
        assertEquals(208, singleNumber.singleNumberWithListModification(testList));
    }

    @Test
    public void powerTest() {
        SingleNumber singleNumber = new SingleNumber();
        assertEquals(1, singleNumber.power(2, 0));
        assertEquals(2, singleNumber.power(2, 1));
        assertEquals(4, singleNumber.power(2, 2));
        assertEquals(8, singleNumber.power(2, 3));
        assertEquals(16, singleNumber.power(2, 4));
        assertEquals(32, singleNumber.power(2, 5));
        assertEquals(64, singleNumber.power(2, 6));
        assertEquals(128, singleNumber.power(2, 7));
        assertEquals(256, singleNumber.power(2, 8));
    }

    @Test
    public void binaryToIntegerTest() {
        SingleNumber singleNumber = new SingleNumber();
        int[] binary = { 0, 0, 1, 1 };
        assertEquals(3, singleNumber.binaryToInt(binary));

        int[] binary1 = { 1, 1, 1, 1 };
        assertEquals(15, singleNumber.binaryToInt(binary1));
    }

    @Test
    public void padWithZerosTest() {
        SingleNumber singleNumber = new SingleNumber();
        assertEquals("00000101", singleNumber.padWithZeros(8, "101"));
        assertEquals("0000000000000110", singleNumber.padWithZeros(16, "110"));
    }

}