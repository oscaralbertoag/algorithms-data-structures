package datastructure.trie.contactlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by oscar on 7/31/16.
 */
public class ContactListTrie {
    private Node root = new Node(false);

    public void addContact(String contact) {
        Node current = root;
        String character;
        for (int i = 0; i < contact.length(); i++) {
            character = String.valueOf(contact.charAt(i));
            // Mark it as 'last' if we've reached the end of the contact
            current.add(character, i==contact.length()-1);
            current = current.get(character);
        }
    }

    public List<String> search(String searchStr) {
        List<String> matchingContacts = new ArrayList<>();
        Node current = root;
        boolean match = false;
        String contactBuffer = "";

        for (int i = 0; i < searchStr.length(); i++) {
            String strChar = String.valueOf(searchStr.charAt(i));
            if (current.contains(strChar)) {
                current = current.get(strChar);
                match = true;
                contactBuffer += strChar;
            } else {
                match = false;
                break;
            }
        }

        if (match) {
            getAllContactsAfterNode(current, contactBuffer, matchingContacts);
        }

        return matchingContacts;
    }

    public void getAllContactsAfterNode(Node current, String contactBuffer, List<String> contacts) {
        if (current != null) {
            if (current.hasChildren()) {
                if(current.isLastCharacter()) {
                    contacts.add(contactBuffer);
                }
                HashMap<String, Node> children = current.getChildren();
                for (String key : children.keySet()) {
                    getAllContactsAfterNode(current.get(key), contactBuffer + key, contacts);
                }
            } else {
                contacts.add(contactBuffer);
            }
        }
    }
}
