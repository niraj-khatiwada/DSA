import java.util.*;

import Tries.Trie;

class Main {

    public static void main(String[] args) {

        var trie = new Trie();
        trie.add("ca");
        trie.add("cat");
        trie.add("car");
        trie.add("carb");

        System.out.println(trie.longestCommonPrefix());

    }

}
