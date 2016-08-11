package datastructure.trie;

/**
 * Created by oscar on 7/17/16.
 */
public class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }


    public void addWord(String word) {
        addWord(word.toLowerCase(), root);
    }

    private void addWord(String word, Node current) {
        if(current != null && word != null) {
            int charIndex = word.charAt(0) - 'a';
            Node[] children = current.getChildren();
            if(children[charIndex] == null) {
                children[charIndex] = new Node(word.charAt(0), current);
                current.setLeaf(false);
            }

            if(children[charIndex] != null){
                current = children[charIndex];
                if(word.length() > 1) {
                    addWord(word.substring(1), current);
                } else {
                    current.setWord(true);
                }

            }
        }
    }

    public boolean contains(String word) {
        String lowerCaseWord = word.toLowerCase();
        if (root != null) {
            Node current = root;
            Node[] children;
            for(int i=0; i<lowerCaseWord.length(); i++) {
                children = current.getChildren();
                int characterIndex = lowerCaseWord.charAt(i) - 'a';
                if(children[characterIndex] != null && children[characterIndex].getCharacter() == lowerCaseWord.charAt(i)){
                    current = children[characterIndex];
                    if(i == lowerCaseWord.length()-1 && !current.isWord()){
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public Node getNode(String word) {
        String lowerCaseWord = word.toLowerCase();
        Node current = root;
        if (root != null) {
            Node[] children;
            for(int i=0; i<lowerCaseWord.length(); i++) {
                children = current.getChildren();
                int characterIndex = lowerCaseWord.charAt(i) - 'a';
                if(children[characterIndex] != null && children[characterIndex].getCharacter() == lowerCaseWord.charAt(i)){
                    current = children[characterIndex];
                    if(i == lowerCaseWord.length()-1 && !current.isWord()){
                        return null;
                    }
                } else {
                    return null;
                }
            }
        }
        return current;
    }


}
