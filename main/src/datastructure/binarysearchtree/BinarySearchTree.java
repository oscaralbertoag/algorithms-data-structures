package datastructure.binarysearchtree;

/**
 * Created by oscar on 6/25/16.
 */
public class BinarySearchTree {

    private Node root;
    private int size;

    private static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int newData) {
            data = newData;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node newLeft) {
            left = newLeft;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node newRight) {
            right = newRight;
        }

        public void print() {
            StringBuilder sb = new StringBuilder();
            sb.append("Node: " + getData());
            System.out.println(sb.toString());
        }
    }

    public Node getRoot() {
        return root;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int data) {
        insert(root, new Node(data));
    }

    private void insert(Node current, Node newNode) {
        if (current != null) {
            if (newNode.getData() < current.getData()) {
                if (current.getLeft() != null) {
                    insert(current.getLeft(), newNode);
                } else {
                    current.setLeft(newNode);
                }
            } else {
                if (current.getRight() != null) {
                    insert(current.getRight(), newNode);
                } else {
                    current.setRight(newNode);
                }
            }
        } else {
            root = newNode;
        }
    }

    public void printPreOrder() {
        if (!isEmpty()) {
            System.out.println("Pre-Order:");
            printPreOrder(root);
            System.out.println();
        }
    }

    private void printPreOrder(Node current) {
        if (isEmpty()) {
            System.out.println("BST is empty!");
        } else if (current != null) {
            System.out.print("|" + current.getData() + "|");
            if (current.getLeft() != null) {
                printPreOrder(current.getLeft());
            }
            if (current.getRight() != null) {
                printPreOrder(current.getRight());
            }
        }
    }

    public void printInOrder() {
        if (!isEmpty()) {
            System.out.println("In-Order:");
            printInOrder(root);
            System.out.println();
        }
    }

    private void printInOrder(Node current) {
        if (isEmpty()) {
            System.out.println("BST is empty!");
        } else if (current != null) {
            if (current.getLeft() != null) {
                printInOrder(current.getLeft());
            }
            System.out.print("|" + current.getData() + "|");
            if (current.getRight() != null) {
                printInOrder(current.getRight());
            }
        }
    }

    public void printPostOrder(){
        if(isEmpty()) {
            System.out.println("BST is empty!");
        } else {
            System.out.println("Post-Order:");
            printPostOrder(root);
            System.out.println();
        }
    }

    private void printPostOrder(Node current){
        if(current != null) {
            if(current.getLeft() != null){
                printPostOrder(current.getLeft());
            }
            if(current.getRight() != null) {
                printPostOrder(current.getRight());
            }
            System.out.print("|" + current.getData() + "|");
        }
    }

    public void printLevelOrder(){
        System.out.println("Level-order:");
        for(int i=1; i<=height(getRoot())+1; i++) {
            printLevel(getRoot(), i);
        }
    }

    private void printLevel(Node root, int level) {
        if(root != null) {
            if(level == 1) {
                System.out.print("|" + root.getData() + "|");
            } else {
                printLevel(root.getLeft(), level-1);
                printLevel(root.getRight(), level-1);
            }
        }
    }

    public void delete(int key) {
        root = delete(root, key);
    }

    private Node delete(Node current, int key) {
        if(current == null) {
            return null;
        } else if(current.getData() == key) {
            if(current.getLeft() == null && current.getRight() == null) {
                return null;
            } else if(current.getLeft() == null) {
                return current.getRight();
            } else if(current.getRight() == null) {
                return current.getLeft();
            } else {
                Node smallest = smallest(current.getRight());
                int tempCurrentData = current.getData();
                current.setData(smallest.getData());
                smallest.setData(tempCurrentData);
                current.setRight(delete(current.getRight(), key));
                return current;
            }
        } else if(key < current.getData()) {
            current.setLeft(delete(current.getLeft(), key));
            return current;
        } else {
            current.setRight(delete(current.getRight(), key));
            return current;
        }
    }

    public Node smallest(Node current) {
        if(current.getLeft() != null) {
            return smallest(current.getLeft());
        } else {
            return current;
        }
    }

    public void printHeight(){
         System.out.println("Height: " + height(root));
    }


    private int height(Node root){
        if(root == null || (root.getLeft() == null && root.getRight() == null)){
            return 0;
        } else {
            int left, right;
            left = height(root.getLeft());
            right = height(root.getRight());
            return 1 + (left>right?left:right);
        }
    }

    public boolean isSubtree(Node current, Node currentSubtree, Node subtreeRoot) {
        if(current != null && currentSubtree != null) {
            if(current.getData() == currentSubtree.getData()) {
                return isSubtree(current.getLeft(), currentSubtree.getLeft(), subtreeRoot) && isSubtree(current.getRight(), currentSubtree.getRight(), subtreeRoot);
            } else {
                return isSubtree(current.getLeft(), subtreeRoot, subtreeRoot) || isSubtree(current.getRight(), subtreeRoot, subtreeRoot);
            }
        } else if((current == null && currentSubtree != null) || (current != null)) {
            return false;
        }
        return true;
    }

    public static void main(String args[]) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(4);
        bst.insert(3);
        bst.insert(5);
        bst.insert(0);
        bst.printInOrder();
        bst.printHeight();
        bst.printLevelOrder();
    }
}
