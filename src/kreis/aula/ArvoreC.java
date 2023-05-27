package kreis.aula;

public class ArvoreC {
    private CharNode root;

    private class CharNode {
        char data;
        CharNode left;
        CharNode right;

        CharNode(char value) {
            data = value;
            left = null;
            right = null;
        }
    }

    public void inserir(char value) {
        root = inserirNo(root, value);
    }

    private CharNode inserirNo(CharNode root, char value) {
        if (root == null) {
            return new CharNode(value);
        }

        if (value < root.data) {
            root.left = inserirNo(root.left, value);
        } else if (value > root.data) {
            root.right = inserirNo(root.right, value);
        }

        return root;
    }

    public void remover(char value) {
        root = removerNo(root, value);
    }

    private CharNode removerNo(CharNode root, char value) {
        if (root == null) {
            return root;
        }

        if (value < root.data) {
            root.left = removerNo(root.left, value);
        } else if (value > root.data) {
            root.right = removerNo(root.right, value);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.data = minValue(root.right);
            root.right = removerNo(root.right, root.data);
        }

        return root;
    }

    private char minValue(CharNode node) {
        char minValue = node.data;
        while (node.left != null) {
            minValue = node.left.data;
            node = node.left;
        }
        return minValue;
    }

    public void traversalPreOrdem() {
        traversalPreOrdem(root);
    }

    private void traversalPreOrdem(CharNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            traversalPreOrdem(root.left);
            traversalPreOrdem(root.right);
        }
    }

    public void traversalEmOrdem() {
        traversalEmOrdem(root);
    }

    private void traversalEmOrdem(CharNode root) {
        if (root != null) {
            traversalEmOrdem(root.left);
            System.out.print(root.data + " ");
            traversalEmOrdem(root.right);
        }
    }

    public void traversalPosOrdem() {
        traversalPosOrdem(root);
    }

    private void traversalPosOrdem(CharNode root) {
        if (root != null) {
            traversalPosOrdem(root.left);
            traversalPosOrdem(root.right);
            System.out.print(root.data + " ");
        }
    }
}