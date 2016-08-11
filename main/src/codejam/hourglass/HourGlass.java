package codejam.hourglass;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by oscar on 7/7/16.
 */
public class HourGlass {
    private int[][] array;
    private PriorityQueue<Integer> maxHeap;

    public HourGlass(int[][] array) {
        this.array = array;

        //Initialize max-heap
        maxHeap = new PriorityQueue<>(1, new Comparator<Integer>() {
            public int compare(Integer int1, Integer int2) {
                return int2 - int1;
            }
        });
    }

    private int processHourGlass(int indexI, int indexJ) {
        int sum = 0;
        int count = 0;
        for(int i=indexI; i<indexI+3; i++) {
            for(int j=indexJ; j<indexJ+3; j++) {
                count++;
                if(count != 4 && count != 6) {
                    sum += array[i][j];
                }
            }
        }
        return sum;
    }

    public int solve() {
        for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++) {
                maxHeap.add(processHourGlass(i,j));
            }
        }
        return maxHeap.remove();
    }

    public static void main(String[] args) throws FileNotFoundException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(new File("/home/oscar/IdeaProjects/googleinterview/src/codejam/hourglass/input.txt"));
        int n = 6;

        // Get input
        int[][] numbers = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                numbers[i][j] = in.nextInt();
            }
        }

        //Initialize HourGlass object
        HourGlass hourGlass = new HourGlass(numbers);
        System.out.print(hourGlass.solve());

    }
}
