package codejam.plusminus;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by oscar on 7/5/16.
 */
public class PlusMinus {
    public static void main(String[] args) throws FileNotFoundException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(new File("/home/oscar/IdeaProjects/googleinterview/src/codejam/plusminus/input.txt"));
        int n = in.nextInt();
        int current = 0;

        int zeroCount = 0;
        int negativeCount = 0;
        int positiveCount = 0;

        int i = n;
        while(i>0) {
            current = in.nextInt();
            if(current == 0) {
                zeroCount++;
            } else if(current > 0) {
                positiveCount++;
            } else {
                negativeCount++;
            }
            i--;
        }
        double positiveFraction = (double)positiveCount/n;
        double negativeFraction = (double)negativeCount/n;
        double zeroFraction = (double)zeroCount/n;
        System.out.println(positiveFraction);
        System.out.println(negativeFraction);
        System.out.println(zeroFraction);
    }
}
