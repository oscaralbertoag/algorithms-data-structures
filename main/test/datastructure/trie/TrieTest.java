package datastructure.trie;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by oscar on 7/18/16.
 */
public class TrieTest {

    @Test
    public void addWordTest() {
        Trie trieUnderTest = new Trie();

        trieUnderTest.addWord("Hello");
        trieUnderTest.addWord("HelloWorld");
        trieUnderTest.addWord("Coffee");
        trieUnderTest.addWord("Success");

        assertTrue(trieUnderTest.contains("Hello"));
        assertTrue(trieUnderTest.contains("hello"));
        assertTrue(trieUnderTest.contains("helloworld"));
        assertTrue(trieUnderTest.contains("coffee"));
        assertTrue(trieUnderTest.contains("success"));
        assertFalse(trieUnderTest.contains("ccess"));
        assertFalse(trieUnderTest.contains("coffe"));
        assertFalse(trieUnderTest.contains("sucess"));
        assertFalse(trieUnderTest.contains("succes"));
        assertFalse(trieUnderTest.contains("hola"));
    }

    @Test
    public void getNodeTest(){
        Trie trieUnderTest = new Trie();

        trieUnderTest.addWord("success");
        trieUnderTest.addWord("coffee");
        trieUnderTest.addWord("BILLIONAIRE");
        trieUnderTest.addWord("wealth");
        trieUnderTest.addWord("aaab");

        assertEquals("aaab", trieUnderTest.getNode("aaab").toString());
        assertEquals("success", trieUnderTest.getNode("success").toString());
        assertEquals("coffee", trieUnderTest.getNode("COFFEE").toString());
        assertEquals("billionaire", trieUnderTest.getNode("billionaire").toString());
        assertEquals("wealth", trieUnderTest.getNode("wealth").toString());
        assertNull(trieUnderTest.getNode("succes"));
        assertNull(trieUnderTest.getNode("coffe"));
        assertNull(trieUnderTest.getNode("billionair"));
        assertNull(trieUnderTest.getNode("sucess"));
        assertNull(trieUnderTest.getNode("halo"));
        assertNull(trieUnderTest.getNode("helo"));
        assertNull(trieUnderTest.getNode("SomeWord"));
    }

}