import Trees.Tree;

class Main {
    public static void main(String[] args) {
        var tree = new Tree();

        tree.insert(7);
        tree.insert(4);
        tree.insert(9);
        tree.insert(1);
        tree.insert(6);
        tree.insert(8);
        tree.insert(10);
        tree.insert(20);
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
        tree.levelOrderTraversal();
    }
}
