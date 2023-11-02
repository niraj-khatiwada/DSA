package BinaryTrees;

import java.util.ArrayList;

public class KthDistanceNode {

    private final Tree tree;

    public KthDistanceNode(Tree tree) {
        this.tree = tree;
    }

    // k means height/distance.
    public ArrayList<Node> findNodes(int k) {
        ArrayList<Node> nodes = new ArrayList<>();
        this.findNodes(this.tree.getRoot(), k, nodes);
        return nodes;
    }

    private void findNodes(Node root, int k, ArrayList<Node> nodes) {
        if (root == null) {
            return;
        }
        if (k == 0) {
            nodes.add(root);
            return;
        }

        if (root.left != null) {
            findNodes(root.left, k - 1, nodes);
        }
        if (root.right != null) {
            findNodes(root.right, k - 1, nodes);
        }
    }
}