package Trees;

import java.util.*;

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

    // O(log(n))
    public void add(int value) {
        var node = new Node(value);

        if (this.root == null) {
            this.root = node;
            return;
        }

        var current = this.root;
        while (true) {
            if (value < current.value) {
                if (current.left == null) {
                    current.left = node;
                    break;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = node;
                    break;
                }
                current = current.right;
            }
        }
    }

    public void addUsingRecursion(int value) {
        if (this.root == null) {
            this.root = new Node(value);
            return;
        }
        this._addUsingRecursion(this.root, value);
    }

    private void _addUsingRecursion(Node node, int value) {
        if (node == null) {
            return;
        }
        if (node.left == null && value < node.value) {
            node.left = new Node(value);
            return;
        }
        if (node.right == null && value > node.value) {
            node.right = new Node(value);
            return;
        }
        _addUsingRecursion(value < node.value ? node.left : node.right, value);
    }

    // O(log(n))
    public boolean find(int value) {
        if (root == null) {
            return false;
        }

        var current = this.root;
        while (current != null) {
            if (value == current.value) {
                return true;
            }
            if (value < current.value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    public boolean findUsingRecursion(int value) {
        if (root == null) {
            return false;
        }
        return this._findUsingRecursion(this.root, value);
    }

    private boolean _findUsingRecursion(Node node, int value) {
        if (node == null) {
            return false;
        }
        if (node.value == value) {
            return true;
        }
        return _findUsingRecursion(value < node.value ? node.left : node.right, value);
    }

    public void preOrderDFS() {
        if (this.root == null) {
            return;
        }
        this._preOrderDFS(this.root);
    }

    private void _preOrderDFS(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value);
        _preOrderDFS(node.left);
        _preOrderDFS(node.right);
    }

    // Pre Order DFS Using Stack
    public void preOrderDFSUsingStack() {
        if (this.root == null) {
            return;
        }
        var stack = new Stack<Node>();
        stack.add(this.root);
        while (!stack.isEmpty()) {
            var n = stack.pop();
            System.out.println(n.value);
            if (n.right != null) {
                stack.add(n.right);
            }
            if (n.left != null) {
                stack.add(n.left);
            }
        }
    }

    public void inOrderDFS() {
        if (this.root == null) {
            return;
        }
        this._inOrderDFS(this.root);
    }

    private void _inOrderDFS(Node node) {
        if (node == null) {
            return;
        }
        _inOrderDFS(node.left);
        System.out.println(node.value);
        _inOrderDFS(node.right);
    }

    // In Order DFS Using Stack
    public void inOrderDFSUsingStack() {
        if (this.root == null) {
            return;
        }
        var stack = new Stack<Node>();
        stack.add(this.root);
        var leftDone = false;
        while (!stack.isEmpty()) {
            if (!leftDone) {
                var n = stack.peek();
                if (n.left != null) {
                    stack.add(n.left);
                    continue;
                }
            }
            leftDone = true;
            var popped = stack.pop();
            System.out.println(popped.value);
            if (popped.right != null) {
                stack.add(popped.right);
            }
        }
    }

    public void postOrderDFS() {
        if (this.root == null) {
            return;
        }
        this._postOrderDFS(this.root);
    }

    private void _postOrderDFS(Node node) {
        if (node == null) {
            return;
        }
        _postOrderDFS(node.left);
        _postOrderDFS(node.right);
        System.out.println(node.value);
    }

    // Post Order DFS Using Stack
    public void postOrderDFSUsingStack() {
        if (this.root == null) {
            return;
        }
        var stack = new Stack<Node>();
        stack.add(this.root);
        var leftDone = false;
        Node rightDone = null;
        while (!stack.isEmpty()) {
            if (!leftDone) {
                var n = stack.peek();
                if (n.left != null) {
                    stack.add(n.left);
                    continue;
                }
            }
            leftDone = true;
            var n = stack.peek();
            if (n.right != null && rightDone != n) {
                stack.push(n.right);
                rightDone = n;
                continue;
            }
            var popped = stack.pop();
            System.out.println(popped.value);
        }
    }

    // Also, see bfs using queue method which is much shorter and easier approach.
    public void bfs() {
        if (this.root == null) {
            return;
        }
        for (var i = 0; i <= this.height(); i++) {
            this.printNodesAtKDistance(i);
        }
    }

    // We can use queue to perform BFS as well
    public void bfsUsingQueue() {
        if (this.root == null) {
            return;
        }
        var queue = new ArrayDeque<Node>();
        // But required O(n) extra space
        queue.add(this.root);
        while (!queue.isEmpty()) {
            var n = queue.remove();
            System.out.println(n.value);
            if (n.left != null) {
                queue.add(n.left);
            }
            if (n.right != null) {
                queue.add(n.right);
            }
        }
    }

    public int height() {
        if (this.root == null) {
            return -1;
        }
        return this.height(this.root);
    }

    public int height(Node node) {
        if (node == null) {
            return 0;
        }
        return this._height(node);
    }

    private int _height(Node node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(_height(node.left), _height(node.right));
    }

    public void printNodesAtKDistance(int k) {
        if (this.root == null) {
            return;
        }
        this._printNodesAtKDistance(this.root, k);
    }

    private void _printNodesAtKDistance(Node node, int k) {
        if (k == 0) {
            if (node != null) {
                System.out.println(node.value);
            }
            return;
        }
        if (node.left != null) {
            _printNodesAtKDistance(node.left, k - 1);
        }
        if (node.right != null) {
            _printNodesAtKDistance(node.right, k - 1);
        }
    }

    // O(n)
    public int getMinimumValue() {
        if (this.root == null) {
            throw new IllegalStateException("Tree is empty");
        }
        return this._getMinimumValue(this.root);
    }

    private int _getMinimumValue(Node node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }
        return Math.min(node.value, Math.min(_getMinimumValue(node.left), _getMinimumValue(node.right)));
    }

    // O(n)
    public int getMaximumValue() {
        if (this.root == null) {
            throw new IllegalStateException("Tree is empty");
        }
        return this._getMaximumValue(this.root);
    }

    private int _getMaximumValue(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        return Math.max(node.value, Math.max(_getMaximumValue(node.left), _getMaximumValue(node.right)));
    }

    // O(log(n))
    // If it is a Binary Search Tree, we can just go the left most node which will
    // be the minimum value
    public int getMinimumValueOfBST() {
        if (this.root == null) {
            throw new IllegalStateException("Tree is empty");
        }
        return this._getMinimumValueOfBST(this.root);
    }

    private int _getMinimumValueOfBST(Node node) {
        if (node.left == null) {
            return node.value;
        }
        return _getMinimumValueOfBST(node.left);
    }

    // O(log(n))
    // If it is a Binary Search Tree, we can just go the right most node which will
    // be the maximum value
    public int getMaximumValueOfBST() {
        if (this.root == null) {
            throw new IllegalStateException("Tree is empty");
        }
        return this._getMaximumValueOfBST(this.root);
    }

    private int _getMaximumValueOfBST(Node node) {
        if (node.right == null) {
            return node.value;
        }
        return _getMaximumValueOfBST(node.right);
    }

    public boolean areTreeEqual(Tree tree) {
        return _areTreeEqual(this.root, tree.root);
    }

    private boolean _areTreeEqual(Node a, Node b) {
        if (a == null) {
            return b == null;
        }
        if (b == null) {
            return a == null;
        }
        if (a.value != b.value) {
            return false;
        }
        return _areTreeEqual(a.left, b.left) == _areTreeEqual(a.right, b.right);
    }

    public boolean isValidBinaryTree() {
        return this._isValidBinaryTree(this.root);
    }

    private boolean _isValidBinaryTree(Node node) {
        if (node == null) {
            return true;
        }
        if (node.left != null && node.right != null) {
            return node.left.value < node.value && node.right.value > node.value;
        }
        if (node.left == null) {
            return node.right.value > node.value;
        }
        if (node.right == null) {
            return node.left.value < node.value;
        }
        return _isValidBinaryTree(node.left) && _isValidBinaryTree(node.right);
    }

    // For test purpose only
    public void flip() {
        if (this.root == null) {
            return;
        }
        var left = this.root.left;
        this.root.left = this.root.right;
        this.root.right = left;
    }

    // Size = Number of nodes
    public int size() {
        return this._size(this.root);
    }

    private int _size(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + _size(node.left) + _size(node.right);
    }

    // Number of leaf nodes or leaves = Nodes with no children
    public int numberOfLeaves() {
        return this._numberOfLeaves(this.root);
    }

    private int _numberOfLeaves(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        return _numberOfLeaves(node.left) + _numberOfLeaves(node.right);
    }

}
