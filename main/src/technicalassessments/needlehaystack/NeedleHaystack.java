package technicalassessments.needlehaystack;

import java.util.ArrayList;
import java.util.List;

public class NeedleHaystack {
    public List<Integer> findAnagrams(String needle, String haystack) {
        List<Integer> indices = new ArrayList<>();

        int n = needle.length();
        List<String> permutations = new ArrayList<>();
        permutations.addAll(permute(needle));
        for (int i = 0; i < haystack.length() - n + 1; i++) {
            if (permutations.contains(haystack.substring(i, i + n))) {
                indices.add(i);
            }
        }

        return indices;
    }

    public List<String> permute(String word) {
        List<String> permutations = new ArrayList<>();
        if (word == null) {
            return permutations;
        }

        if (word.length() == 1) {
            permutations.add(word);
        } else if (word.length() == 2) {
            char[] permutation = new char[2];
            permutation[0] = word.charAt(1);
            permutation[1] = word.charAt(0);
            permutations.add(word);
            permutations.add(new String(permutation));
        } else {
            List<String> partialPermutations = new ArrayList<>();
            for (int i = 0; i < word.length(); i++) {
                StringBuilder substring = new StringBuilder(word);
                partialPermutations.clear();
                partialPermutations.addAll(permute(substring.deleteCharAt(i).toString()));
                for (String substr : partialPermutations) {
                    String sb = String.valueOf(word.charAt(i)) + substr;
                    permutations.add(sb);
                }
            }
        }
        return permutations;
    }
}
