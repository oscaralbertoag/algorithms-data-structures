package codejam.exponential;

/**
 * Created by oscar on 7/2/16.
 */
public class Exponential {

    public static int power(int k, int n ) {
        if(n == 0) {
            return 1;
        } else {
            return k * power(k, n-1);
        }
    }

    public static void main(String[] args) {
        for(int i=0; i<11; i++) {
            System.out.println("Result of 2^" + i + ": " + power(2, i));
        }
    }
}
