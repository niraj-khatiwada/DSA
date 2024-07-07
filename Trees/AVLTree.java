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
        this.root = _insert(this.root, value);
    }

    private Node _insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value > node.value) {
            node.right = _insert(node.right, value);
        } else {
            node.left = _insert(node.left, value);
        }
        node.height = this._calculateHeight(node);
        return this._balance(node);
    }

    private Node _balance(Node node) {
        var rootBalanceFactor = this._findBalanceFactor(node);
        if (rootBalanceFactor > 1) {
            // Imbalance found on left side
            System.out.printf("Imbalance found on left side at %s. Height = %s\n", node.value, node.height);
            // Now, we need to detect if imbalance is L(Left Skewed), or LR(Left-Right).
            var leftNodeBalanceFactor = this._findBalanceFactor(node.left);
            // Left Skewed -> BF will be positive
            if (leftNodeBalanceFactor > 0) {
                System.out.printf("Left Skewed. Perform Right rotation at %s\n", node.value);
                // Since we need to rotate right on both cases, we'll do at the end after
                // checking if it is LR or not. See first return statement below.
            } else {
                // Left Right -> BF will be negative
                System.out.printf(
                        "Need Left-Right rotation. Perform Left rotation at %s and then Right rotation at %s\n",
                        node.left.value, node.left.right.value);
                node.left = this._rotateLeft(node.left);
            }
            return this._rotateRight(node);

        }
        if (rootBalanceFactor < -1) {
            // Imbalance found on right side
            System.out.printf("Imbalance found on right side at %s. Height = %s\n", node.value, node.height);
            // Now we need to detect if imbalance is R(Right Skewed) or RL(Right-Left)
            var rightNodeBalanceFactor = this._findBalanceFactor(node.right);
            // Right Skewed = BF negative
            if (rightNodeBalanceFactor < 0) {
                System.out.printf("Right Skewed. Perform Left rotation at %s\n", node.value);
                // Since we need to rotate left on both cases, we'll do at the end after
                // checking if it is RL or not. See first return statement below.
            } else {
                // Right Left = BF positive
                System.out.printf(
                        "Need Right-Left rotation. Perform Right rotation at %s and then Left rotation at %s\n",
                        node.right.value, node.right.left.value);
                node.right = this._rotateRight(node.right);
            }
            return this._rotateLeft(node);
        }
        return node;
    }

    public Node _rotateRight(Node node) {
        var oldRoot = node;
        node = node.left;
        oldRoot.left = null;
        if (node.right == null) {
            node.right = oldRoot;
        } else {
            var rightSubTree = node.right;
            node.right = oldRoot;
            node.right.left = rightSubTree;
        }
        node.right.height = this._calculateHeight(node.right); // old root
        node.height = this._calculateHeight(node); // new root
        return node;
    }

    public Node _rotateLeft(Node node) {
        var oldRoot = node;
        node = node.right;
        oldRoot.right = null;
        if (node.left == null) {
            node.left = oldRoot;
        } else {
            var leftSubTree = node.left;
            node.left = oldRoot;
            node.left.right = leftSubTree;
        }
        node.left.height = this._calculateHeight(node.left); // old root
        node.height = this._calculateHeight(node); // new root
        return node;
    }

    public int _findBalanceFactor(Node node) {
        return this._height(node.left) - this._height(node.right);
    }

    public int height() {
        return this._height(this.root);
    }

    private int _height(Node node) {
        return node == null ? -1 : node.height;
    }

    private int _calculateHeight(Node node) {
        return 1 + Math.max(this._height(node.left), this._height(node.right));
    }

}
