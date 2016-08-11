package codejam.diagonaldifference;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by oscar on 7/5/16.
 */
public class DiagonalDifference {
    public static void main(String[] args) throws FileNotFoundException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(new File("/home/oscar/IdeaProjects/googleinterview/src/codejam/diagonaldifference/input.txt"));
        int n = in.nextInt();
        int i = 0;
        int j = 0;
        int sumD1 = 0;
        int sumD2 = 0;

        while(i<n) {
            j = 0;
            while(j<n) {
                if(i == j) {
                    int temp = in.nextInt();
                    sumD1 += temp;
                    if(n%2 != 0 && i==n/2) {
                        sumD2 += temp;
                    }
                } else if((n-1)-i == j) {
                    sumD2 += in.nextInt();
                } else {
                    // Consume next, discard
                    in.nextInt();
                }
                j++;
            }
            i++;
        }
        System.out.print(Math.abs(sumD1 - sumD2));
    }
}
