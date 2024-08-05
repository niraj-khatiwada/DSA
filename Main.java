import java.util.*;

import Trees.Tree;

class Main {

    public static void main(String[] args) {
        var tree = new Tree();

        tree.add(12);
        tree.add(3);
        tree.add(15);
        // tree.add(4);
        // tree.add(6);
        // tree.add(2);

        System.out.println(tree.isBTBalanced());

    }

}
