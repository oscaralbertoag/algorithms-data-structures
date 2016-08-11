package codejam.permutations;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by oscar on 8/6/16.
 */
public class PermutationsTest {

    @Test
    public void getPermutationsTest() {

        Permutations permutationsUnderTest = new Permutations();
        String[] expected = {"abc", "acb", "bac", "bca", "cab", "cba"};
        List<String> expectedList = Arrays.asList(expected);
        String[] permutations = permutationsUnderTest.permutations("abc");
        List<String> permutationList = Arrays.asList(permutations);

        assertEquals(expectedList.size(), permutationList.size());
        for(int i=0; i<expectedList.size(); i++) {
            assertTrue(expectedList.contains(permutations[i]));
            assertTrue(permutationList.contains(expected[i]));
        }
    }

    @Test
    public void getPermutationsTest_2() throws FileNotFoundException {
        Permutations permutationsUnderTest = new Permutations();
        List<String> results = Arrays.asList(permutationsUnderTest.permutations("abcde"));

        // Generate expected results
        Scanner in = new Scanner(new File("/home/oscar/IdeaProjects/googleinterview/main/src/codejam/permutations/input.txt"));
        List<String> expectedList = new ArrayList<>();
        while(in.hasNext()) {
            expectedList.add(in.next());
        }

        assertEquals(expectedList.size(), results.size());
        for(int i=0; i<expectedList.size(); i++) {
            assertTrue(expectedList.contains(results.get(i)));
            assertTrue(results.contains(expectedList.get(i)));
        }


    }

}