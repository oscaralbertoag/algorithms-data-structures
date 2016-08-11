package algorithm;

/**
 * Created by oscar on 6/15/16.
 */
public class Selection {


    public static void sort(int[] array) {

        int lowestIndex;
        for(int i=0; i<array.length; i++) {
            lowestIndex = i;
            for(int j=i+1; j<array.length; j++) {
                if(array[j] < array[lowestIndex]) {
                    lowestIndex = j;
                }
            }
            swap(array, lowestIndex, i);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
