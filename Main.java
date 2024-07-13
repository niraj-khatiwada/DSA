import Tries.TrieUsingArray;
import Tries.TrieUsingHashMap;

class Main {
    public static void main(String[] args) {
        var tries = new TrieUsingHashMap();
        tries.add("boy");
        tries.add("book");
        tries.add("cat");
        System.out.println(tries.countWords());

    }

}
