package Trees;

import java.util.ArrayList;

public class BinaryTree {
    private class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node root;

    private boolean _isLeadNode(Node node) {
        return node.left == null && node.right == null;
    }

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

    public boolean equals(BinaryTree tree) {
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

    public int size() {
        return this._size(this.root);
    }

    private int _size(Node node) {
        if (node == null) {
            return 0;
        }

        return 1 + _size(node.left) + _size(node.right);
    }

    // Leaf Nodes = node.left == null && node.right==null
    public int countLeafNodes() {
        return this._countLeafNode(this.root);
    }

    private int _countLeafNode(Node node) {
        if (node == null) {
            return 0;
        }
        if (this._isLeadNode((node))) {
            return 1;
        }
        return _countLeafNode(node.left) + _countLeafNode(node.right);
    }

    public int findMaxValue() {
        return this._findMaxValue(this.root);
    }

    private int _findMaxValue(Node node) {
        if (this._isLeadNode(node)) {
            return node.value;
        }

        if (node.left == null) {
            return node.right.value;
        }

        if (node.right == null) {
            return node.left.value;
        }

        return Math.max(node.value, Math.max(_findMaxValue(node.left), _findMaxValue(node.right)));
    }

    public boolean contains(int value) {
        return this._contains(this.root, value);
    }

    private boolean _contains(Node node, int value) {
        if (node == null) {
            return false;
        }
        if (this._isLeadNode(node)) {
            return node.value == value;
        }

        return _contains(node.left, value) || _contains(node.right, value);
    }

    public boolean areSiblings(int value1, int value2) {
        return this.depth(value1) == this.depth(value2);
    }

    public int depth(int value) {
        if (this.root == null) {
            return 0;
        }
        int d = 0;
        var currentNode = this.root;
        while (currentNode != null) {
            if (currentNode.value == value) {
                return d;
            }
            currentNode = value < currentNode.value ? currentNode.left : currentNode.right;
            d++;
        }
        return -1;
    }

    public ArrayList<Integer> findAncestors(int value) {
        var ancestors = new ArrayList<Integer>();

        var currentNode = this.root;

        while (currentNode != null) {
            if (currentNode.value == value) {
                return ancestors;
            }
            ancestors.add(currentNode.value);
            currentNode = value < currentNode.value ? currentNode.left : currentNode.right;
        }

        return new ArrayList<>();
    }

}

// var tree = new BinaryTree();
// tree.insert(1);
// tree.insert(2);
// tree.insert(3);

// tree.insert(7);
// tree.insert(4);
// tree.insert(9);
// tree.insert(1);
// tree.insert(6);
// tree.insert(8);
// tree.insert(10);
// tree.insert(20);
// tree.traversePreOrder();
// tree.traverseInOrder();
// tree.traversePostOrder();
// System.out.println(tree.height());
// System.out.println(tree.findMinValue());
// System.out.println(tree.findMinValueOfBTree());

// var tree2 = new Tree();

// tree2.insert(7);
// tree2.insert(4);
// tree2.insert(9);
// tree2.insert(1);
// tree2.insert(6);
// tree2.insert(8);
// tree2.insert(10);
// tree2.insert(20);

// System.out.println(tree.equals(tree2));

// tree.swapBranches();
// System.out.println(tree.isBinarySearchTree());

// tree.findNodesAtKthDistance(2);
// tree.levelOrderTraversal();
// System.out.println(tree.countLeafNodes());
// System.out.println(tree.findMaxValue());
// System.out.println(tree.contains(20));
// System.out.println(tree.depth(100));
// System.out.println(tree.areSiblings(8, 10));
// System.out.println(tree.findAncestors(100));
// System.out.println(tree.height());