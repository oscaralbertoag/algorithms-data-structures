package datastructure.trie.contactlist;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by oscar on 7/31/16.
 */
public class ContactListTrieTest {

    @Test
    public void addContactTest_oneContact() {
        ContactListTrie trieUnderTest = new ContactListTrie();

        trieUnderTest.addContact("Katie");
        assertTrue(trieUnderTest.search("K").contains("Katie"));
        assertTrue(trieUnderTest.search("Kat").contains("Katie"));
        assertTrue(trieUnderTest.search("Katie").contains("Katie"));
        assertTrue(trieUnderTest.search("Kati").contains("Katie"));
        assertFalse(trieUnderTest.search("Kate").contains("Katie"));
        assertFalse(trieUnderTest.search("k").contains("Katie"));
        assertEquals(1, trieUnderTest.search("K").size());
        assertEquals(1, trieUnderTest.search("Ka").size());
        assertEquals(1, trieUnderTest.search("Kat").size());
        assertEquals(1, trieUnderTest.search("Kati").size());
        assertEquals(1, trieUnderTest.search("Katie").size());
        assertEquals(0, trieUnderTest.search("Kate").size());
        assertEquals(0, trieUnderTest.search("Katies").size());
        assertEquals(0, trieUnderTest.search("a").size());
    }

    @Test
    public void addContactTest_multipleContacts() {
        ContactListTrie trieUnderTest = new ContactListTrie();

        trieUnderTest.addContact("Katie");
        trieUnderTest.addContact("Oscar");
        trieUnderTest.addContact("Kate");
        trieUnderTest.addContact("Kathy");

        // Search for "Kat"
        assertEquals(3,trieUnderTest.search("Kat").size());
        assertTrue(trieUnderTest.search("Kat").contains("Katie"));
        assertTrue(trieUnderTest.search("Kat").contains("Kate"));
        assertTrue(trieUnderTest.search("Kat").contains("Kathy"));
        // Search for "Cath"
        assertEquals(0, trieUnderTest.search("Cath").size());
        // Search for "Oscar", "Osc"
        assertEquals(1, trieUnderTest.search("Oscar").size());
        assertTrue(trieUnderTest.search("Oscar").contains("Oscar"));
        assertTrue(trieUnderTest.search("Osc").contains("Oscar"));
        assertFalse(trieUnderTest.search("Oscr").contains("Oscar"));
    }

    @Test
    public void addContactTest_twoContacts() {
        ContactListTrie trieUnderTest = new ContactListTrie();

        trieUnderTest.addContact("hack");
        trieUnderTest.addContact("hackerrank");
        assertEquals(2, trieUnderTest.search("hac").size());
        assertEquals(0, trieUnderTest.search("hak").size());
    }

}