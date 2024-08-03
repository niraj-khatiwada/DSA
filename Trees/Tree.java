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

}
