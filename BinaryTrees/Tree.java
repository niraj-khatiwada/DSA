package BinaryTrees;

public class Tree {
    private static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public void insert(int value) {
        Node node = new Node(value);
        if (this.root == null) {
            this.root = node;
            return;
        }
        Node current = this.root;
        while (true) {
            if (value < current.value) {
                if (current.left == null) {
                    current.left = node;
                    break;
                } else {
                    current = current.left;
                }
            } else {
                if (current.right == null) {
                    current.right = node;
                    break;
                } else {
                    current = current.right;
                }
            }
        }
    }

    public boolean has(int value) {
        if (this.root == null) {
            return false;
        }
        boolean hasValue = false;
        Node current = this.root;
        while (current != null) {
            System.out.println(current.value);
            if (value == current.value) {
                hasValue = true;
                break;
            }
            current = value < current.value ? current.left : current.right;
        }
        return hasValue;
    }
}