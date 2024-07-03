package Trees;

public class Tree {
    private class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    // log(n)
    public void insert(int value) {
        var node = new Node(value);

        if (this.root == null) {
            this.root = node;
            return;
        }
        var currentNode = this.root;

        while (currentNode != null) {
            if (value < currentNode.value) {
                if (currentNode.left == null) {
                    currentNode.left = node;
                    break;
                }
                currentNode = currentNode.left;
            } else {
                if (currentNode.right == null) {
                    currentNode.right = node;
                    break;
                }
                currentNode = currentNode.right;
            }
        }
    }

    public boolean find(int value) {
        if (this.root == null) {
            return false;
        }
        var currentNode = this.root;

        while (currentNode != null) {
            if (currentNode.value == value) {
                return true;
            }
            currentNode = value < currentNode.value ? currentNode.left : currentNode.right;
        }
        return false;
    }
}