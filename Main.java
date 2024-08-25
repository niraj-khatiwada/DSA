import java.util.*;

import Trees.BinaryTree;

class Main {

    public static void main(String[] args) {
        var btree = new BinaryTree();
        btree.add(5);
        btree.add(3);
        btree.add(7);
        btree.add(2);
        btree.add(4);
        btree.add(6);
        btree.add(8);
        btree.traversePostOrderUsingStack();
    }

}
