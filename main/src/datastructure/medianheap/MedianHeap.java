package datastructure.medianheap;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by oscar on 7/30/16.
 */
public class MedianHeap {

    private PriorityQueue<Double> maxHeap;
    private PriorityQueue<Double> minHeap;

    public MedianHeap() {
        maxHeap = new PriorityQueue<Double>(new Comparator<Double>() {
            @Override
            public int compare(Double a, Double b) {
                return b.compareTo(a);
            }
        });
        minHeap = new PriorityQueue<>();
    }

    public void insert(double number) {
        // If both are empty, insert at the left arbitrarily
        if(maxHeap.isEmpty() && minHeap.isEmpty()) {
            maxHeap.add(number);
            return;
        }

        int difference = Math.abs(maxHeap.size() - minHeap.size());

        if (difference == 0) {
            if (number <= getMedian()) {
                maxHeap.add(number);
            } else {
                minHeap.add(number);
            }
        } else {
            if(number <= getMedian()) {
                if(maxHeap.size() > minHeap.size()) {
                    balanceHeaps();
                }
                maxHeap.add(number);
            } else {
                if(minHeap.size() > maxHeap.size()) {
                    balanceHeaps();
                }
                minHeap.add(number);
            }
        }
    }

    private void balanceHeaps() {
        if(maxHeap.size() > minHeap.size()) {
            minHeap.add(maxHeap.poll());
        } else if(minHeap.size() > maxHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double getMedian() {
        if(maxHeap.size() == minHeap.size() && !heapsAreEmpty()) {
            return (maxHeap.peek() + minHeap.peek())/2;
        } else if(maxHeap.size()> minHeap.size()) {
            return maxHeap.peek();
        } else if(minHeap.size()> maxHeap.size()){
            return minHeap.peek();
        } else {
            return 0;
        }
    }

    public BigDecimal getMedianWithPrecision(int precision) {
        double median = getMedian();
        return new BigDecimal(median).setScale(precision, RoundingMode.HALF_UP);
    }

    private boolean heapsAreEmpty() {
        return maxHeap.isEmpty() && minHeap.isEmpty();
    }
}
