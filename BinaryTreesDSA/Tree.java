package BinaryTreesDSA;

public class Tree {
    private Node root;

    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }
    }

    // O(log n)
    public void insert(int value) {
        Node newNode = new Node(value);
        if (this.root == null) {
            this.root = newNode;
            return;
        }
        Node current = root;
        while (true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = newNode;
                    break;
                }
                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    current.rightChild = newNode;
                    break;
                }
                current = current.rightChild;
            }
        }

    }

    // O(log n)
    public boolean find(int value) {
        Node current = this.root;
        while (current != null) {
            if (value < current.value) {
                current = current.leftChild;
            } else if (value > current.value) {
                current = current.rightChild;
            } else {
                return true;
            }
        }
        return false;
    }

    public void traversePreOrder() {
        this.traversePreOrder(this.root);
    }

    private void traversePreOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    public void traverseInOrder() {
        this.traverseInOrder(this.root);
    }

    private void traverseInOrder(Node root) {
        if (root == null) {
            return;
        }
        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }

    public void traversePostOrder() {
        this.traversePostOrder(this.root);
    }

    private void traversePostOrder(Node root) {
        if (root == null) {
            return;
        }
        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }

    public int height() {
        return this.height(this.root);
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        if (node.leftChild == null && node.rightChild == null) {
            return 0;
        }
        return 1 + Math.max(height(node.leftChild), height(node.rightChild));
    }

    // O(n)
    public int min() {
        return this.min(this.root);
    }

    private int min(Node node) {

        if (node == null) {
            throw new IllegalAccessError();
        }
        if (node.leftChild == null && node.rightChild == null) {
            return node.value;
        }
        int left = node.leftChild != null ? min(node.leftChild) : node.value;
        int right = node.rightChild != null ? min(node.rightChild) : node.value;

        return Math.min(Math.min(left, right), node.value);
    }

    // O(log n)
    public int minBinarySearchTree() {
        return this.minBinarySearchTree(this.root);
    }

    private int minBinarySearchTree(Node node) {
        if (node == null) {
            throw new IllegalAccessError();
        }

        Node current = node;
        Node last = current;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }

        return last.value;
    }

    public boolean equals(Tree tree) {
        if (tree == null) {
            return this.root == null;
        }
        return this.equals(tree.root, this.root);
    }

    public boolean equals(Node comparisonNode, Node baseNode) {
        if (comparisonNode == null && baseNode == null) {
            return true;
        }

        if (comparisonNode != null && baseNode != null) {
            return comparisonNode.value != baseNode.value && equals(comparisonNode.leftChild, baseNode.leftChild)
                    && equals(comparisonNode.rightChild, baseNode.rightChild);
        }

        return false;
    }

}
