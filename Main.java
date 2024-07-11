import Tries.TrieUsingArray;

class Main {
    public static void main(String[] args) {
        var tries = new TrieUsingArray();
        tries.add("boy");
        tries.add("book");
        System.out.println(tries.autocomplete("b"));

    }

}
