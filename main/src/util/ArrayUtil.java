package util;

import java.util.Random;

/**
 * Created by oscar on 6/14/16.
 */
public class ArrayUtil {

    public static void print(int[] array){
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            sb.append((i != array.length - 1) ? ", " : "");
        }
        sb.append(" ]");
        System.out.println(sb.toString());
    }

    public static void print(char[] word) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for(int i=0; i< word.length; i++) {
            sb.append(word[i]);
            sb.append(i != word.length -1 ? ", " : "");
        }
        sb.append(" ]");
        System.out.println(sb.toString());
    }

    public static int[] getRandomArray(int n) {
        int[] randomArray = new int[n];
        Random random = new Random();
        int i = 0;
        while(i < n) {
            randomArray[i] = random.nextInt();
            i++;
        }
        return randomArray;
    }
}
