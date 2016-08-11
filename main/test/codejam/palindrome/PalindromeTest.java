package codejam.palindrome;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by oscar on 8/6/16.
 */
public class PalindromeTest {

    @Test
    public void reverseCharacterArrayTest(){
        Palindrome palindromeUnderTest = new Palindrome();
        char[] word = {'E' ,'I', 'T', 'A', 'K'};
        palindromeUnderTest.reverseCharacterArray(word);

        char[] expected = {'K', 'A', 'T', 'I', 'E'};
        for(int i=0; i<expected.length; i++) {
            assertEquals(expected[i], word[i]);
        }
    }


    @Test
    public void reverseCharacterArrayTest_2(){
        Palindrome palindromeUnderTest = new Palindrome();
        char[] word = {'A' ,'B', 'C', 'D'};
        palindromeUnderTest.reverseCharacterArray(word);

        char[] expected = {'D', 'C', 'B', 'A'};
        for(int i=0; i<expected.length; i++) {
            assertEquals(expected[i], word[i]);
        }
    }

    @Test
    public void palindromesTest() {
        Palindrome palindromeUnderTest = new Palindrome();
        char[] word = {'a', 'b', 'a', 'c', 'b'};
        List<String> resultingPalindromes = palindromeUnderTest.getAllPalindromes(word);

        assertTrue(resultingPalindromes.contains("abcba"));
        assertTrue(resultingPalindromes.contains("bacab"));
        assertEquals(2, resultingPalindromes.size());
    }
}