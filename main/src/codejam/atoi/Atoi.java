package codejam.atoi;

import java.util.Stack;

/**
 * Created by oscar on 6/27/16.
 */
public class Atoi {
    public static int intArrayToInt(int[] number) {
        Stack<Integer> stack = new Stack<>();
        int result=0;
        int decimalPosition=0;

        for(int i=0; i<number.length; i++) {
            stack.push(number[i]);
        }
        while(!stack.empty()){
            result += (power(10, decimalPosition++)) * stack.pop();
        }
        return result;
    }

    public static int charArrayToInt(char[] number) {
        int result = 0;
        int decimalPosition = number.length-1;
        for(int i=0; i<number.length; i++) {
            result += power(10, decimalPosition--)* (number[i] - '0');
        }
        return result;
    }

    public static int power(int base, int exponent) {
        if (exponent > 0) {
            return base * power(base, exponent-1);
        }
        else return 1;
    }

    public static void main(String[] args) {
        char[] number = {'2','3','4','6','0'};
        System.out.print("Result: " + Atoi.charArrayToInt(number));
    }
}
