package codejam.combinations;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by oscar on 7/29/16.
 */
public class CombinationsTest {

    @Test
    public void getAllCombinationsTest() {
        Combinations combinationsUnderTest = new Combinations();
        List<String> combinations = combinationsUnderTest.getAllCombinations("ABC");

        String[] expected = {"", "C", "B", "BC", "A", "AC", "AB", "ABC"};

        assertEquals(8, combinations.size());
        for(String str : expected) {
            assertTrue(combinations.contains(str));
        }
    }

    @Test
    public void getCombinationsInAlphabeticalOrder() {
        Combinations combinationsUnderTest = new Combinations();
        List<String> combinations = combinationsUnderTest.getCombinationsInAlphabeticalOrder("ABC");

        String[] expected = {"", "A", "AB", "ABC", "AC", "B", "BC", "C"};

        assertEquals(8, combinations.size());
        for(int i=0; i<combinations.size(); i++) {
            assertTrue(combinations.contains(expected[i]));
            assertEquals(expected[i], combinations.get(i));
        }
    }

}