package datastructure.linkedlist;

/**
 * Created by oscar on 6/22/16.
 */
public class LinkedList {

    private Node root;
    private int size = 0;

    private class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void print() {
            StringBuilder sb = new StringBuilder();
            sb.append("Node: |" + getData() + "|");
            System.out.println(sb.toString());
        }
    }

    public int getSize() {
        return size;
    }

    public void add(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            root = newNode;
        } else {
            Node temp = root;
            root = newNode;
            newNode.setNext(temp);

        }
        size++;
    }

    public void remove(int key) {
        remove(root, key);
    }

    private void remove(Node current, int key) {
        if (current != null) {
            Node temp;
            if (current == root && current.getData() == key) {
                removeRoot();
                remove(root, key);
            } else if (current != root & current.getData() == key) {
                // Can't remove current from here, go back to beginning
                remove(root, key);
            } else if (current.getNext() != null && current.getNext().getData() == key) {
                temp = current.getNext().getNext();
                current.setNext(temp);
                size--;
            }
            remove(current.getNext(), key);
        }
    }

    public Node removeRoot() {
        if (!isEmpty()) {
            Node temp = root;
            root = root.getNext();
            size--;
            return temp;
        }
        return null;
    }


    public void removeDuplicates() {
        removeDuplicates(root);
    }

    private void removeDuplicates(Node current, int key) {
        if(current != null) {
            if(current.getNext() != null && current.getNext().getData() == key) {
                current.setNext(current.getNext().getNext());
                size--;
                removeDuplicates(current, key);
            } else {
                removeDuplicates(current.getNext(), key);
            }
        }
    }

    private void removeDuplicates(Node baseIterationNode) {
        while(baseIterationNode != null) {
            removeDuplicates(baseIterationNode, baseIterationNode.getData());
            baseIterationNode = baseIterationNode.getNext();
        }
    }

    public void reverse() {
        reverse(null, root);
    }

    private void reverse(Node previous, Node current){
        if(current != null) {
            Node next = null;
            if(current == root) {
                next = current.getNext();
                current.setNext(null);
                reverse(current, next);
            } else {
                next = current.getNext();
                current.setNext(previous);
                reverse(current, next);
            }
        } else {
            root = previous;
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void print() {
        Node current = root;
        System.out.print("Linked List: ");
        while (current != null) {
            System.out.print("|" + current.getData() + "|");
            current = current.getNext();
        }
        System.out.println();
    }

    public void printSize() {
        System.out.println("Size: " + size);
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.print();
        linkedList.printSize();
        linkedList.reverse();
        linkedList.print();
        linkedList.printSize();
    }

}
