package algorithm;

import util.ArrayUtil;

/**
 * Created by oscar on 6/14/16.
 */
public class Insertion {

    public static final int ASCENDING = 0;
    public static final int DESCENDING = 1;

    public static void sort(int[] array, int order) {
        int count = 0;

        for (int i= 1; i<array.length; i++){
            for(int j=i-1; j>=0; j--){
                if(swap(array, j, order)){
                } else break;
                 count++;
            }
        }
//        System.out.println(count);
    }

    public static boolean swap(int[] array, int index, int order){
        int temp;
        boolean swapOccurred = false;
        if (order == ASCENDING && index+1 < array.length) {
            if(array[index] > array[index+1]) {
                // Swap
                temp = array[index+1];
                array[index+1] = array[index];
                array[index] = temp;
                swapOccurred = true;
            }
        }
        else if (order == DESCENDING && index+1 < array.length){
            if(array[index] < array[index+1]) {
                // Swap
                temp = array[index+1];
                array[index + 1] = array[index];
                array[index] = temp;
                swapOccurred = true;
            }
        }
        return swapOccurred;
    }

    public static void main(String[] args) {
        int[] array = {4,3,1,5,6};
        Insertion.sort(array, ASCENDING);
        ArrayUtil.print(array);
    }
}
