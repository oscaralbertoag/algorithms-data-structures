package codejam.reversestring;

/**
 * Created by oscar on 6/27/16.
 */
public class ReverseString {

    public static String reverseIteratively(char[] word) {
        StringBuilder sb = new StringBuilder();
        for (int i = word.length - 1; i >= 0; i--) {
            sb.append(word[i]);
        }
        return sb.toString();
    }

    public static void printReverseRecursively(char[] word, int index) {
        if (index >= 0) {
            System.out.print(word[index]);
            printReverseRecursively(word, index - 1);
        }
    }

    public static void reverseRecursively(char[] word) {
        reverseRecursively(0, word.length - 1, word);
    }

    private static void reverseRecursively(int indexA, int indexB, char[] word) {
        char temp = 0;
        int smallestDifference = word.length % 2 == 0 ? 0 : 1;

        if (indexB - indexA > smallestDifference) {
            temp = word[indexA];
            word[indexA] = word[indexB];
            word[indexB] = temp;
            reverseRecursively(indexA + 1, indexB - 1, word);
        }
    }

    public static void main(String[] args) {
        char[] word = {'s', 't', 'r', 'i', 'n', 'g'};
        ReverseString.reverseRecursively(word);
        System.out.print(word);

    }
}
