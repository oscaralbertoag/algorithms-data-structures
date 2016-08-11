package datastructure.trie;

import java.util.Stack;

/**
 * Created by oscar on 7/17/16.
 */
public class Node {
    private Node[] children = new Node[26];
    private boolean word = false;
    private boolean leaf = true;
    private Node parent;
    private char character;

    public Node(){}

    public Node(char character) {
        this.character = character;
    }

    public Node(char character, Node parent) {
        this.character = character;
        this.parent = parent;
    }

    public Node[] getChildren() {
        return children;
    }

    public boolean isWord() {
        return word;
    }

    public void setWord(boolean isWord) {
        word = isWord;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean isLeaf) {
        leaf = isLeaf;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public Node getParent() {
        return parent;
    }

    @Override
    public String toString() {
        Stack<Character> characterStack = new Stack<>();
        characterStack.push(getCharacter());
        Node previous = parent;
        while(previous.getParent() != null){
            characterStack.push(previous.getCharacter());
            previous = previous.getParent();
        }
        StringBuilder sb = new StringBuilder();
        while(!characterStack.isEmpty()) {
            sb.append(characterStack.pop());
        }
        return sb.toString();
    }

}
