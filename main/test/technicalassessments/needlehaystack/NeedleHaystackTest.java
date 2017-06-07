package technicalassessments.needlehaystack;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
public class NeedleHaystackTest {

    @Test
    @Parameters(method = "findAnagramsParams")
    public void findAnagrams(String haystack, String needle, List<Integer> expectedIndices) {
        NeedleHaystack needleHaystack = new NeedleHaystack();
        List<Integer> anagramIndices = needleHaystack.findAnagrams(needle, haystack);

        for (int index : expectedIndices) {
            assertTrue(anagramIndices.contains(index));
        }
    }

    public Object[] findAnagramsParams() {
        Object[] scenario1 = { "axzbcabcebac", "abc", Arrays.asList(3, 4, 5, 9) };

        return new Object[] { scenario1 };
    }

    @Test
    @Parameters(method = "permuteParams")
    public void permute(List<String> expected, String word) {
        NeedleHaystack needleHaystack = new NeedleHaystack();
        List<String> result = needleHaystack.permute(word);

        assertEquals(expected.size(), result.size());
        for (String expectedWord : expected) {
            assertTrue(result.contains(expectedWord));
        }
    }

    public Object[] permuteParams() {
        Object[] scenario1 = { Arrays.asList("abc", "acb", "bac", "bca", "cab", "cba"), "abc" };
        Object[] scenario2 =
            { Arrays.asList("abcd", "abdc", "acbd", "acdb", "adbc", "adcb", "badc", "bacd", "bcda", "bcad", "bdca", "bdac", "cabd",
                "cadb", "cbad", "cbda", "cdab", "cdba", "dacb", "dabc", "dbca", "dbac", "dcba", "dcab"), "abcd" };

        return new Object[] { scenario1, scenario2 };
    }

}