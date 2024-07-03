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

    public void traversePreOrder() {
        this._traversePreOrder(this.root);
    }

    private void _traversePreOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value);
        _traversePreOrder(node.left);
        _traversePreOrder(node.right);
    }

    public void traverseInOrder() {
        this._traverseInOrder(this.root);
    }

    private void _traverseInOrder(Node node) {
        if (node == null) {
            return;
        }
        _traverseInOrder(node.left);
        System.out.println(node.value);
        _traverseInOrder(node.right);
    }

    public void traversePostOrder() {
        this._traversePostOrder(this.root);
    }

    private void _traversePostOrder(Node node) {
        if (node == null) {
            return;
        }
        _traversePostOrder(node.left);
        _traversePostOrder(node.right);
        System.out.println(node.value);
    }

    public int height() {
        return this._height(this.root);
    }

    private int _height(Node node) {
        if (node == null) {
            return -1; // We've to cancel the (1 + ...) value here so we need to return -1 instead of
                       // zero. Otherwise, the height of void node will be 1 which should be 0.
        }
        return 1 + Math.max(_height(node.left), _height(node.right));
    }
}