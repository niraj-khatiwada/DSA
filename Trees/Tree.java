package Trees;

import java.util.ArrayList;

public class Tree {
    private class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node root;

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

    // O(n)
    public int findMinValue() {
        if (this.root == null) {
            throw new IllegalStateException("No items in tree.");
        }
        return this._findMinValue(this.root);
    }

    private int _findMinValue(Node node) {
        if (node.left == null && node.right == null) {
            return node.value;
        }
        if (node.left == null) {
            return node.right.value;
        }
        if (node.right == null) {
            return node.left.value;
        }
        return Math.min(node.value, Math.min(_findMinValue(node.left), _findMinValue(node.right)));
    }

    // O(log(n))
    public int findMinValueOfBTree() {
        if (this.root == null) {
            throw new IllegalStateException("No items in tree.");
        }
        var currentValue = this.root;
        while (true) {
            if (currentValue.left == null) {
                break;
            }
            currentValue = currentValue.left;
        }
        return currentValue.value;
    }

    public boolean equals(Tree tree) {
        return this._equals(this.root, tree.root);
    }

    private boolean _equals(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 != null && node2 != null) {
            return node1.value == node2.value && _equals(node1.left, node2.left) && _equals(node1.right, node2.right);

        }
        return false;
    }

    public boolean isBinarySearchTree() {
        return this._isBinarySearchTree(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean _isBinarySearchTree(Node node, int min, int max) {
        if (node == null) {
            return true;
        }
        if (node.value < min || node.value > max) {
            return false;
        }
        return _isBinarySearchTree(node.left, min, node.value - 1)
                && _isBinarySearchTree(node.right, node.value + 1, max);
    }

    public void swapBranches() {
        var right = this.root.right;
        this.root.right = this.root.left;
        this.root.left = right;
    }

    // This is also the same way we find nodes at given level k.
    public ArrayList<Integer> findNodesAtKthDistance(int k) {
        var list = new ArrayList<Integer>();
        _findNodesAtKthDistance(this.root, k, list);
        return list;
    }

    private void _findNodesAtKthDistance(Node node, int k, ArrayList<Integer> list) {
        if (node == null) {
            return;
        }
        if (k == 0) {
            list.add(node.value);
            return;
        }
        _findNodesAtKthDistance(node.left, k - 1, list);
        _findNodesAtKthDistance(node.right, k - 1, list);

    }

    public void levelOrderTraversal() {
        for (var i = 0; i <= this.height(); i++) {
            for (var item : findNodesAtKthDistance(i)) {
                System.out.println(item);
            }
        }
    }

}