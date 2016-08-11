package codejam.binarynumbers;

/**
 * Created by oscar on 7/29/16.
 */
public class BinaryNumbers {
    private int[] number;
    private String[] results;
    private int count = 0;

    public String[] generate(int n, boolean print) {
        number = new int[n];
        results = new String[power(2, n)];

        for(int i=0; i<n; i++) {
            number[i] = 0;
        }
        generate(n, 0, print);
        return results;
    }

    public void generate(int n, int index, boolean print) {

        if(index == n) {
            results[count] = numberArrayToString();
            if(print) {
                System.out.print("Number " + count++ + " ");
                printArray();
            }
        } else {
            // Current position is not set
            number[index] = 0;
            generate(n, index +1, print);
            // Current position is set
            number[index] = 1;
            generate(n, index +1, print);
        }
    }

    public void printArray() {
        for(int i=0; i<number.length; i++) {
            System.out.print("|"+number[i]);
        }
        System.out.println("|");
    }

    public String numberArrayToString() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<number.length; i++) {
            sb.append(number[i]);
        }
        return sb.toString();
    }

    public int power(int n, int power) {
        if(power == 0) {
            return 1;
        } else {
            return n * power(n, power-1);
        }
    }

    public static void main(String[] args) {
        BinaryNumbers binaryNumbers = new BinaryNumbers();
        binaryNumbers.generate(4, true);
    }
}
