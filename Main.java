import Trees.Tree;

class Main {
    public static void main(String[] args) {
        var tree = new Tree();

        tree.insert(10);
        tree.insert(9);
        tree.insert(12);
        tree.insert(15);
        tree.insert(1);
        System.out.println(tree.find(120));
    }
}
