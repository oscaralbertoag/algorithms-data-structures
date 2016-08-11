package codejam.palindrome;

import codejam.permutations.Permutations;

import java.util.*;
import java.util.stream.Collector;

/**
 * Created by oscar on 8/6/16.
 */
public class Palindrome {

    private Permutations permutator = new Permutations();
    private List<String> palindromes = new ArrayList<>();

    public List<String> getAllPalindromes(char[] word) {
        List<Character> halfPalindrome = new ArrayList<>();
        Map<Character, Integer> charMap = new HashMap<>();

        for (char aCharacter : word) {
            Integer count = charMap.get(aCharacter);
            if (count == null) {
                charMap.put(aCharacter, 1);
            } else if (count == 1) {
                charMap.remove(aCharacter);
                halfPalindrome.add(aCharacter);
            }
        }
        List<Character> remaining = new ArrayList<>();
        remaining.addAll(charMap.keySet());
        String middleChar = "";
        if(!remaining.isEmpty()){
            middleChar = remaining.get(0).toString();
        }

        String[] permutationsOfHalfPalindrome = permutator.permutations(halfPalindrome);
        for(String halfpal : permutationsOfHalfPalindrome) {
            palindromes.add(halfpal + middleChar + reverseCharacterArrayToString(halfpal.toCharArray()));
        }
        return palindromes;
    }

    protected void reverseCharacterArray(char[] word) {
        char temp;
        for(int i=0; i<word.length/2; i++) {
            temp = word[i];
            word[i] = word[word.length-1-i];
            word[word.length-1-i] = temp;
        }
    }

    protected String reverseCharacterArrayToString(char[] word) {
        char temp;
        for(int i=0; i<word.length/2; i++) {
            temp = word[i];
            word[i] = word[word.length-1-i];
            word[word.length-1-i] = temp;
        }
        return new String(word);
    }
}
