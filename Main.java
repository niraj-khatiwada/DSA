import Trees.AVLTree;
import Trees.BinaryTree;

class Main {
    public static void main(String[] args) {
        var avlTree = new AVLTree();
        // avlTree.insert(5);
        // avlTree.insert(4);
        // avlTree.insert(7);
        // avlTree.insert(9);
        // avlTree.insert(3);
        // avlTree.insert(11);
        // avlTree.insert(1);
        // avlTree.insert(2);
        // avlTree.insert(3);
        // avlTree.insert(5);
        // avlTree.insert(4);
        // avlTree.insert(8);
        // avlTree.insert(7);
        // avlTree.insert(4);
        // System.out.println(avlTree.height());

        var bTree = new BinaryTree();
        bTree.insert(3);
        bTree.insert(1);
        bTree.insert(4);
        System.out.println(bTree.numberOfLeafNodes());
        System.out.println(bTree.isPerfect());
    }
}
