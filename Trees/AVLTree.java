package Trees;

public class AVLTree {
    private class Node {
        public int value;
        public int height = 0;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    public void insert(int value) {
        if (this.root == null) {
            var newNode = new Node(value);
            this.root = newNode;
            return;
        }
        _insert(this.root, value);

    }

    private void _insert(Node node, int value) {
        if (node == null) {
            return;
        }
        var newNode = new Node(value);
        if (value < node.value && node.left == null) {
            node.left = newNode;
            node.height = this._height(node);
            return;
        }
        if (value > node.value && node.right == null) {
            node.right = newNode;
            node.height = this._height(node);
            return;
        }
        node.height = this._height(node);
        _insert(value < node.value ? node.left : node.right, value);

    }

    public int height() {
        return this._height(this.root);
    }

    private int _height(Node node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(_height(node.left), _height(node.right));
    }

    private boolean _isLeafNode(Node node) {
        return node.left == null && node.right == null;
    }

}
