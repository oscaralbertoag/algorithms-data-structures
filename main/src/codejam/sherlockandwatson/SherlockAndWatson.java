package codejam.sherlockandwatson;

import java.util.Scanner;

/**
 * Created by oscar on 7/18/16.
 */
public class SherlockAndWatson {

    private int[] array;
    private int n;
    private int k;
    private int[] queryArray;

    public SherlockAndWatson(int[] array, int n, int k, int[] queryArray) {
        this.array = array;
        this.n = n;
        this.k = k;
        this.queryArray = queryArray;
    }


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();

        int[] array = new int[n];
        for(int i=0; i<n; i++) {
            array[i] = in.nextInt();
        }
        int queryIndex, rotation, rotationIndex;
        while(in.hasNextInt()){
            queryIndex = in.nextInt();
            if(k>n-1) {
                rotation = k%n;
            } else {
                rotation = k-1;
            }
            rotationIndex = queryIndex + rotation;
            if(rotationIndex>n-1) {
                rotationIndex = rotationIndex%n;
            }
            System.out.println(array[rotationIndex]);
        }

    }

    public void executeAllQueries() {
        for(int index : queryArray) {
            System.out.println(getRotatedPosition(index));
        }
    }

    public int getRotatedPosition(int q) {
        int rotation, rotationIndex, queryIndex;
        queryIndex = q;
        if(k>n-1) {
            rotation = k%n;
            if(rotation == 0) {
                rotation--;
            }
            rotationIndex = queryIndex + rotation +1;
        } else {
            rotation = k-1;
            rotationIndex = queryIndex + rotation;
        }
        if(rotationIndex>n-1) {
            rotationIndex = rotationIndex%n;
        }
        return array[rotationIndex];
    }
}
