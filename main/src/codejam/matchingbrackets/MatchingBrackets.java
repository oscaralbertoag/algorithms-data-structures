package codejam.matchingbrackets;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * Created by oscar on 7/9/16.
 */
public class MatchingBrackets {
    public void processMatchingBrackets(String str){
        Deque<Character> deque = new ArrayDeque<Character>();
        boolean matching = true;
        if(str.length()%2 != 0) {
            System.out.println("NO");
        } else {
            for(int i=0; i<str.length(); i++) {
                deque.add(str.charAt(i));
            }
            char previous = 'E';
            while(!deque.isEmpty()){
                char left = deque.removeFirst();
                char right = deque.removeLast();
                if(!isMatchingBracket(left, right, previous)){
                    matching = false;
                    break;
                }
                previous = left;
            }
            System.out.println(matching?"YES":"NO");
        }

    }

    private boolean isMatchingBracket(char left, char right, char previous) {
        boolean matching = true;
        if(previous != 'E') {
            if(previous == '{'){
                matching = isMatchingAngleBracket(left, right) || isMatchingSquareBracket(left, right);
            } else if(previous == '[') {
                matching = isMatchingSquareBracket(left, right) || isMatchingParenthesis(left, right);
            } else if(previous == '(') {
                matching = isMatchingParenthesis(left, right);
            }
        } else {
            matching = isMatchingAngleBracket(left, right) || isMatchingSquareBracket(left, right) || isMatchingParenthesis(left, right);
        }
        return matching;
    }

    private boolean isMatchingParenthesis(char left, char right) {
        return (left == '(' && right == ')');
    }

    private boolean isMatchingAngleBracket(char left, char right) {
        return (left == '{' && right == '}' );
    }

    private boolean isMatchingSquareBracket(char left, char right) {
        return (left == '[' && right == ']');
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("/home/oscar/IdeaProjects/googleinterview/src/codejam/matchingbrackets/input.txt"));
        MatchingBrackets solution = new MatchingBrackets();
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            String s = in.next();
            solution.processMatchingBrackets(s);
        }
    }
}
