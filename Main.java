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

        System.out.println(tree.height());
    }
}
