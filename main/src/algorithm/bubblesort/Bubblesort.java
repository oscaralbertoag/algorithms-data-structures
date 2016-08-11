package algorithm.bubblesort;

/**
 * Created by oscar on 7/19/16.
 */
public class Bubblesort {

    public void sort(int[] array) {
        int currentMaxIndex = 0;
        int n = array.length;
        int m = n;

        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (array[currentMaxIndex] < array[i]) {
                    currentMaxIndex = i;
                }
                if (i == n - 1) {
                    swap(currentMaxIndex, n - 1, array);
                    n--;
                    currentMaxIndex = 0;
                }
            }
        }
    }

    private void swap(int indexA, int indexB, int[] array) {
        int temp = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = temp;
    }
}
