import Tries.TrieUsingArray;
import Tries.TrieUsingHashMap;

class Main {
    public static void main(String[] args) {
        var tries = new TrieUsingHashMap();
        tries.add("boy");
        tries.add("book");
        System.out.println(tries.longestCommonPrefix());

    }

}
