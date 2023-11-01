package BinaryTrees;


import java.util.ArrayList;

public class Tree {


    public enum Direction {
        ASC, DESC
    }

    private Node root;

    public Node getRoot() {
        return this.root;
    }

    public void insert(int value) {
        Node node = new Node(value);
        if (this.root == null) {
            this.root = node;
            return;
        }
        Node current = this.root;
        while (true) {
            if (value < current.value) {
                if (current.left == null) {
                    current.left = node;
                    break;
                } else {
                    current = current.left;
                }
            } else {
                if (current.right == null) {
                    current.right = node;
                    break;
                } else {
                    current = current.right;
                }
            }
        }
    }

    public boolean has(int value) {
        if (this.root == null) {
            return false;
        }
        boolean hasValue = false;
        Node current = this.root;
        while (current != null) {
            if (value == current.value) {
                hasValue = true;
                break;
            }
            current = value < current.value ? current.left : current.right;
        }
        return hasValue;
    }

    // This is the same has implementation using recursion.
    public boolean contains(int value) {
        return this.contains(this.root, value);
    }

    private boolean contains(Node root, int value) {
        if (root == null) {
            return false;
        }

        boolean left = root.left == null ? root.value == value : contains(root.left, value);
        boolean right = root.right == null ? root.value == value : contains(root.right, value);

        return root.value == value || left || right;
    }


    // Root, Left, Right
    public void traversePreorder() {
        this.traversePreorder(this.root);
    }

    private void traversePreorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        traversePreorder(root.left);
        traversePreorder(root.right);
    }


    public void traverseInOrder() {
        this.traverseInOrder(this.root, Direction.ASC);
    }

    public void traverseInOrder(Direction direction) {
        this.traverseInOrder(this.root, direction);
    }

    private void traverseInOrder(Node root, Direction direction) {
        if (root == null) {
            return;
        }
        traverseInOrder(direction == Direction.ASC ? root.left : root.right, direction);
        System.out.println(root.value);
        traverseInOrder(direction == Direction.ASC ? root.right : root.left, direction);
    }

    public void traversePostOrder() {
        this.traversePostOrder(this.root);
    }

    private void traversePostOrder(Node root) {
        if (root == null) {
            return;
        }
        traversePostOrder(root.left);
        traversePostOrder(root.right);
        System.out.println(root.value);
    }


    // BFS
    public void traverseLevelOrder() {
        KthDistanceNode kthDistanceNode = new KthDistanceNode(this);
        for (int i = 0; i <= this.height(); i++) {
            for (var node : kthDistanceNode.findNodes(i)) {
                System.out.println(node.value);
            }
        }
    }

    public int height() {
        return this.height(this.root);
    }

    private int height(Node root) {
        if (root == null || root.left == null && root.right == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));

    }

    public int min() {
        return this.min(this.root);
    }

    // This is the basic Binary Tree implementation.
    // In Binary Search Tree, the min value will always be the left most node.

    // Time complexity of this one is O(n)
    //    private int min(Node root) {
    //        if (root == null) {
    //            throw new Error("No elements");
    //        }
    //        if (root.left == null && root.right == null) {
    //            return root.value;
    //        }
    //        var left = root.left != null ? min(root.left) : root.value;
    //        var right = root.right != null ? min(root.right) : root.value;
    //        return Math.min(root.value, Math.min(left, right));
    //
    //    }


    // Time Complexity = O(logn)
    private int min(Node root) {
        if (root == null) {
            throw new Error("No elements");
        }
        var current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.value;

    }

    public boolean isEqual(Tree tree) {
        if (tree == null) {
            return false;
        }
        return isEqual(this.root, tree.root);
    }

    // Check root first and then leafs -> Pre-Order Traversal
    private boolean isEqual(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.value != root2.value) {
            return false;
        }
        return isEqual(root1.left, root2.left) && isEqual(root1.right, root2.right);

    }


//    public boolean isBinaryTree() {
//        return this.isBinaryTree(this.root);
//    }

    // This solution traverses through all the left and right nodes to check with root nodes.
    // T.C = O(n)
    // This solution is costly.
//    private boolean isBinaryTree(Node root) {
//        if ((root.left == null && root.right == null)) {
//            return true;
//        }
//
//        if (root.left == null) {
//            return root.right.value >= root.value;
//        }
//
//        if (root.right == null) {
//            return root.left.value < root.value;
//        }
//
//        var left = isBinaryTree(root.left) && root.left.value < root.value;
//        var right = isBinaryTree(root.right) && root.right.value >= root.value;
//
//        return left && right;
//    }


    public boolean isBinaryTree() {
        return isBinaryTree(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    private boolean isBinaryTree(Node root, int min, int max) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        if (root.value <= min || root.value > max) {
            return false;
        }
        return isBinaryTree(root.left, min, root.value - 1) && isBinaryTree(root.right, root.value, max);
    }


    // Number of nodes.
    public int getSize() {
        return this.getSize(this.root);
    }

    private int getSize(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + getSize(root.left) + getSize(root.right);
    }

    public int getLeavesCount() {
        return this.getLeavesCount(this.root);
    }

    // Nodes beside root.
    private int getLeavesCount(Node root) {
        if (root == null) {
            return 0;
        }
        return getSize(root.left) + getSize(root.right);
    }

    // This is basic implementation for binary tree. In Binary Search Tree, the max value is always the right most node.
//    public int max() {
//        return this.max(this.root);
//    }
//
//    private int max(Node root) {
//        if (root == null) {
//            throw new Error("No elements.");
//        }
//        if (root.left == null && root.right == null) {
//            return root.value;
//        }
//        int left = root.left != null ? max(root.left) : root.value;
//        int right = root.right != null ? max(root.right) : root.value;
//        return Math.max(root.value, Math.max(left, right));
//
//
//    }

    public int max() {
        if (this.root == null) {
            throw new Error("No elements.");
        }
        Node current = this.root;
        while (true) {
            current = current.right;
            if (current.right == null) {
                break;
            }
        }
        return current.value;
    }

    public boolean areSiblings(int value1, int value2) {
        KthDistanceNode kthDistanceNode = new KthDistanceNode(this);
        for (int i = 0; i <= this.height(); i++) {
            var nodes = kthDistanceNode.findNodes(i);
            ArrayList<Integer> list = new ArrayList<>();
            for (var node : nodes) {
                if (value1 == node.value || value2 == node.value) {
                    list.add(node.value);
                }
            }
            if (list.size() == 2) {
                return true;
            }
        }
        return false;
    }


    public ArrayList<Integer> getAncestors(int value) {
        var ancestors = new ArrayList<Integer>();
        if (root == null) {
            return ancestors;
        }
        if (root.value == value) {
            return ancestors;
        }
        ancestors.add(root.value);
        return getAncestors(value, this.root, ancestors);
    }

    private ArrayList<Integer> getAncestors(int value, Node root, ArrayList<Integer> ancestors) {
        if (root.left != null) {
            if (value < root.left.value) {
                ancestors.add(root.left.value);
                return getAncestors(value, root.left, ancestors);
            }
        }
        if (root.right != null) {
            if (value >= root.right.value) {
                ancestors.add(root.right.value);
                return getAncestors(value, root.right, ancestors);
            }
        }
        return ancestors;

    }

}