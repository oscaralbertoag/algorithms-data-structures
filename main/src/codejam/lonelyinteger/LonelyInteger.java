package codejam.lonelyinteger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * There are integers in an array . All but one integer occur in pairs. Your task is to find the number that occurs only once.
 * Explanation: a ^ a = 0; Therefore, a ^ x ^ a = x
 */
public class LonelyInteger {
    private static int lonelyInteger(int[] a) {
        int result = 0;
        for(int i=0; i<a.length; i++) {
            result^=a[i];
        }
        return result;
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("/home/oscar/IdeaProjects/googleinterview/src/codejam/lonelyinteger/input.txt"));
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        System.out.println(lonelyInteger(a));
    }
}
