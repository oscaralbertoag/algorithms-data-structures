package codejam.permutations;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by oscar on 8/6/16.
 */
public class Permutations {

    public String[] permutations(String word) {
        return getPermutations(word).toArray(new String[word.length()]);
    }

    public String[] permutations(List<Character> word) {
        StringBuilder sb = new StringBuilder();
        for (Character character : word) {
            sb.append(character);
        }
        return getPermutations(sb.toString()).toArray(new String[word.size()]);
    }

    private Set<String> getPermutations(String word) {
        Set<String> permutations = new TreeSet<>();
        if (word != null) {
            if(word.length() == 1) {
                permutations.add(word);
            } else if(word.length() == 2) {
                permutations.add(word);
                permutations.add(String.valueOf(word.charAt(1)) + String.valueOf(word.charAt(0)));
            } else {
                for(int i=0; i<word.length(); i++) {
                    Set<String> subPermutations = getPermutations(removeCharAtIndex(i, word));
                    for(String str : subPermutations) {
                        permutations.add(String.valueOf(word.charAt(i)) + str);
                    }
                }
            }
        }
        return permutations;
    }

    protected String removeCharAtIndex(int index, String str) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++) {
            if(i != index) {
                sb.append(String.valueOf(str.charAt(i)));
            }
        }
        return sb.toString();
    }
}
