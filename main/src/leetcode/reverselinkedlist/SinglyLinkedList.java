package leetcode.reverselinkedlist;

public class SinglyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getSize() {
        return size;
    }

    public Node add(int value) {
        if (head == null) {
            head = new Node(null, value);
            tail = head;
        } else {
            Node newNode = new Node(null, value);
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
        return head;
    }

    public Node reverse() {
        Node node = head;
        head = tail;
        tail = node;
        Node previous = null;
        while (node != null) {
            Node oldNext = node.getNext();
            node.setNext(previous);
            previous = node;
            node = oldNext;
        }
        return head;
    }

    public void print() {
        Node node = head;
        while (node != null) {
            System.out.print(" " + node.getValue() + " ");
            node = node.getNext();
        }
        System.out.println();
    }

    public int[] toArray() {
        Node node = head;
        int[] arr = new int[size];
        int index = 0;
        while (node != null) {
            arr[index++] = node.getValue();
            node = node.getNext();
        }
        return arr;
    }

}
