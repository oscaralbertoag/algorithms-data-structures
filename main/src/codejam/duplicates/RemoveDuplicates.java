package codejam.duplicates;

import util.ArrayUtil;

import java.util.Arrays;

/**
 * Created by oscar on 6/21/16.
 */
public class RemoveDuplicates {
    public char[] removeDuplicates(char[] word) {
        for(int i=0; i<word.length-1; i++){
            for(int j=i+1; j<word.length; j++){
                if(word[i] == word[j]){
                    return removeDuplicates(moveLeft(j, word));
                }
            }
        }
        return word;
    }

    private char[] moveLeft(int index, char[] word) {
        char[] result = new char[word.length - 1];
        int resultIndex = 0;

        for(int i=0; i<word.length; i++) {
            if(i != index) {
                result[resultIndex++] = word[i];
            }
        }
        return result;
    }

    public static void main(String[] args){
        char[] word = {'A', 'B', 'B', 'C', 'D', 'E', 'F', 'A', 'A' };
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        ArrayUtil.print(removeDuplicates.removeDuplicates(word));

    }
}
