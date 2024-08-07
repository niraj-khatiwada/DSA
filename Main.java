import java.util.*;

import Tries.Trie;

class Main {

    public static void main(String[] args) {

        var trie = new Trie();
        trie.add("cat");
        trie.add("car");
        trie.add("carb");

        trie.remove("car");
        trie.print();
    }

}
