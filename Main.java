import java.util.*;

import Tries.Trie;

class Main {

    public static void main(String[] args) {

        var trie = new Trie();
        trie.add("bad");
        trie.add("mad");
        trie.add("dad");

        System.out.println(trie.search(".ad"));
    }

}
