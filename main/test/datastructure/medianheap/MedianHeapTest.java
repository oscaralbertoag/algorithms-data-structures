package datastructure.medianheap;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by oscar on 7/30/16.
 */
public class MedianHeapTest {

    @Test
    public void getMedianTest() {
        MedianHeap medianHeapUnderTest = new MedianHeap();

        medianHeapUnderTest.insert(5);
        assertEquals(5, medianHeapUnderTest.getMedian(), 0.001);
        assertEquals(new BigDecimal(5).setScale(1), medianHeapUnderTest.getMedianWithPrecision(1));
        medianHeapUnderTest.insert(2);
        assertEquals(3.5, medianHeapUnderTest.getMedian(), 0.001);
        assertEquals(new BigDecimal(3.5).setScale(1), medianHeapUnderTest.getMedianWithPrecision(1));
        medianHeapUnderTest.insert(1);
        assertEquals(2, medianHeapUnderTest.getMedian(), 0.001);
        assertEquals(new BigDecimal(2).setScale(1), medianHeapUnderTest.getMedianWithPrecision(1));
        medianHeapUnderTest.insert(8);
        assertEquals(3.5, medianHeapUnderTest.getMedian(), 0.001);
        assertEquals(new BigDecimal(3.5).setScale(1), medianHeapUnderTest.getMedianWithPrecision(1));
        medianHeapUnderTest.insert(0);
        assertEquals(2, medianHeapUnderTest.getMedian(), 0.001);
        assertEquals(new BigDecimal(2).setScale(1), medianHeapUnderTest.getMedianWithPrecision(1));
        medianHeapUnderTest.insert(4);
        assertEquals(3, medianHeapUnderTest.getMedian(), 0.001);
        assertEquals(new BigDecimal(3).setScale(1), medianHeapUnderTest.getMedianWithPrecision(1));
    }

    @Test
    public void getMedianWithPrecision() {
        MedianHeap medianHeapUnderTest = new MedianHeap();

        medianHeapUnderTest.insert(1);
        assertEquals(new BigDecimal(1).setScale(1), medianHeapUnderTest.getMedianWithPrecision(1));
        medianHeapUnderTest.insert(2);
        assertEquals(new BigDecimal(1.5).setScale(1), medianHeapUnderTest.getMedianWithPrecision(1));
        medianHeapUnderTest.insert(3);
        assertEquals(new BigDecimal(2).setScale(1), medianHeapUnderTest.getMedianWithPrecision(1));
        medianHeapUnderTest.insert(4);
        assertEquals(new BigDecimal(2.5).setScale(1), medianHeapUnderTest.getMedianWithPrecision(1));
        medianHeapUnderTest.insert(5);
        assertEquals(new BigDecimal(3).setScale(1), medianHeapUnderTest.getMedianWithPrecision(1));
        medianHeapUnderTest.insert(6);
        assertEquals(new BigDecimal(3.5).setScale(1), medianHeapUnderTest.getMedianWithPrecision(1));
        medianHeapUnderTest.insert(7);
        assertEquals(new BigDecimal(4).setScale(1), medianHeapUnderTest.getMedianWithPrecision(1));
        medianHeapUnderTest.insert(8);
        assertEquals(new BigDecimal(4.5).setScale(1), medianHeapUnderTest.getMedianWithPrecision(1));
        medianHeapUnderTest.insert(9);
        assertEquals(new BigDecimal(5).setScale(1), medianHeapUnderTest.getMedianWithPrecision(1));
        medianHeapUnderTest.insert(10);
        assertEquals(new BigDecimal(5.5).setScale(1), medianHeapUnderTest.getMedianWithPrecision(1));
    }
}