import Trees.AVLTree;

class Main {
    public static void main(String[] args) {
        var avlTree = new AVLTree();
        avlTree.insert(5);
        avlTree.insert(4);
        avlTree.insert(7);
        avlTree.insert(9);
        avlTree.insert(3);
        System.out.println(avlTree.height());
    }
}
