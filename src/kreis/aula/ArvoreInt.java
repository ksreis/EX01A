package kreis.aula;

public class ArvoreInt {
    private Node root;

    private class Node {
        int data;
        Node left;
        Node right;

        Node(int value) {
            data = value;
            left = null;
            right = null;
        }
    }

    public void insert(int value) {
        root = insertNode(root, value);
    }

    private Node insertNode(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }

        if (value < root.data) {
            root.left = insertNode(root.left, value);
        } else if (value > root.data) {
            root.right = insertNode(root.right, value);
        }

        return root;
    }

    public void printInOrder() {
        printInOrderTraversal(root);
    }

    private void printInOrderTraversal(Node root) {
        if (root != null) {
            printInOrderTraversal(root.left);
            System.out.print(root.data + " ");
            printInOrderTraversal(root.right);
        }
    }

    public boolean search(int value) {
        return searchNode(root, value);
    }

    private boolean searchNode(Node root, int value) {
        if (root == null) {
            return false;
        }

        if (value == root.data) {
            return true;
        } else if (value < root.data) {
            return searchNode(root.left, value);
        } else {
            return searchNode(root.right, value);
        }
    }
}