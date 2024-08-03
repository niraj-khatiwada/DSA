import java.util.*;

import Trees.Tree;

class Main {

    public static void main(String[] args) {
        var tree = new Tree();

        tree.add(6);
        tree.add(7);
        tree.add(4);
        tree.add(5);
        tree.add(3);
        tree.add(1);

        System.out.println(tree.find(1));
    }

}
