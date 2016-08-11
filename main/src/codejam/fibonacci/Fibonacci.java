package codejam.fibonacci;

/**
 * Created by oscar on 6/28/16.
 */
public class Fibonacci {
    public static int calculate(int n) {
        if(n <= 2) {
            return 1;
        } else {
            return calculate(n-1) + calculate(n-2);
        }
    }

    public static void main(String[] args) {
        for(int i=1; i<11; i++) {
            System.out.println("N=" + i + ": " + Fibonacci.calculate(i));
        }
    }
}
