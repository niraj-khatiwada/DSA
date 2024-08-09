package Tree;

public class AVLTree {
    private class Node {
        public int value;
        public int height;

        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node root;

    public void add(int value) {
        this.root = this._add(this.root, value);
    }

    private Node _add(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.value) {
            node.left = _add(node.left, value);
        } else {
            node.right = _add(node.right, value);
        }
        node = this._balance(node);

        return node;
    }

    private Node _balance(Node node) {
        node.height = _calculateHeight(node);
        var bf = _balanceFactor(node);
        if (Math.abs(bf) > 1) {
            if (bf < -1) {
                // We need to detect if this is R-skewed or RL
                if (_balanceFactor(node.right) < 0) {
                    // Right Skewed
                } else {
                    // RL
                    node.right = _rotateRight(node.right); // We need to rotate the right node not the the node itself.
                                                           // That's why we need to mutate node.right = ...
                }
                node = _rotateLeft(node);

            } else {
                // We need to detect if this is L-skewed or LR
                if (_balanceFactor(node.left) > 0) {
                    // Left Skewed
                } else {
                    // LR
                    node.left = _rotateLeft(node.left); // We need to rotate the left node not the node itself.
                                                        // That's why we need to mutate node.left = ...
                }
                node = _rotateRight(node);
            }
        }
        return node;
    }

    private Node _rotateRight(Node node) {
        var r = node;
        var lrref = node.left.right;
        node = node.left;
        r.left = null;
        node.right = r;
        node.right.left = lrref;

        node.right.height = _calculateHeight(node.right);
        node.height = _calculateHeight(node);
        return node;
    }

    private Node _rotateLeft(Node node) {
        var r = node;
        var rlref = node.right.left;
        node = node.right;
        r.right = null;
        node.left = r;
        node.left.right = rlref;

        node.left.height = _calculateHeight(node.left);
        node.height = _calculateHeight(node);
        return node;
    }

    private int _balanceFactor(Node node) {
        return _height(node.left) - _height(node.right);
    }

    private int _height(Node node) {
        return node == null ? -1 : node.height;
    }

    private int _calculateHeight(Node node) {
        if (node == null) {
            return -1;
        }

        return 1 + Math.max(_height(node.left), _height(node.right));
    }

}
