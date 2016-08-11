package algorithm.quicksort;

/**
 * Created by oscar on 7/16/16.
 */
public class Quicksort {

    private int[] array;

    public Quicksort(final int[] array) {
        this.array = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            this.array[i] = array[i];
        }
    }


    public int[] sort() {
        if (array.length > 0) {
            partition(0, array.length - 1);
        }
        return array;
    }

    /**
     * Shifts elements one position to the right leaving the element at the start position empty.
     *
     * @param start       index that will be left empty
     * @param end         index of the position that is currently empty
     * @param numToInsert value to insert in the cleared position
     */
    protected void shiftRight(int start, int end, int numToInsert) {
        if (end < array.length) {
            for (int i = end; i > start; i--) {
                array[i] = array[i - 1];
            }
            array[start] = numToInsert;
        }
    }

    private void partition(int start, int end) {
        int pivot = array[end];
        int emptyIndex = end;

        for (int i = start; i <= end; i++) {
            if (emptyIndex > i) { // We are to the left of the empty space (temporarily holding our pivot)
                if (array[i] > pivot) {
                    shiftRight(i, end, pivot);
                    emptyIndex = i;
                    i++;
                }
            } else if (emptyIndex < i) { // We are to the right of the empty space (temporarily holding our pivot)
                if (array[i] < pivot) {
                    array[emptyIndex] = array[i];
                    shiftRight(++emptyIndex, i, pivot);
                }
            }
        }
        if (emptyIndex - 1 > start) {
            partition(start, emptyIndex - 1);
        }
        if (emptyIndex + 1 < end) {
            partition(emptyIndex + 1, end);
        }
    }

    public void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print("|" + array[i] + "|");
        }
        System.out.println();
    }

    public int[] getArray() {
        return array;
    }
}
