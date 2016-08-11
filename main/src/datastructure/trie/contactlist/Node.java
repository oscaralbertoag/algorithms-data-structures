package datastructure.trie.contactlist;

import java.util.HashMap;

/**
 * Created by oscar on 7/31/16.
 */
public class Node {
    private HashMap<String, Node> characterMap;
    private boolean isLastCharacter;

    public Node(boolean isLastCharacter) {
        characterMap = new HashMap<>();
        this.isLastCharacter = isLastCharacter;
    }

    public void add(String character, boolean last) {
        if(!characterMap.containsKey(character)) {
            characterMap.put(character, new Node(last));
        }
    }

    public Node get(String key) {
        return characterMap.get(key);
    }

    public boolean contains(String key) {
        return get(key) != null;
    }

    public boolean hasChildren() {
        return !characterMap.isEmpty();
    }

    public HashMap<String, Node> getChildren() {
        return characterMap;
    }

    public boolean isLastCharacter() {
        return isLastCharacter;
    }
}
