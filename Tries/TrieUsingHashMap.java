package Tries;

import java.util.HashMap;

public class TrieUsingHashMap {
    private class Node {
        public char value;
        public HashMap<Character, Node> children;
        public int occurrenceCount;
        public boolean isEnd = false;

        public Node() {
            this.children = new HashMap<Character, Node>();
        }

        public Node(char value) {
            this.children = new HashMap<Character, Node>();
            this.value = value;
            this.occurrenceCount = 1;
        }

    }

    public Node root;

    public TrieUsingHashMap() {
        this.root = new Node();
    }

    // O(L); L = length of word
    public void insert(String w) {
        if (w == null) {
            throw new IllegalArgumentException("Invalid word");
        }
        String word = w.toLowerCase();
        Node levelNode = this.root;
        for (var character : word.toCharArray()) {
            var value = levelNode.children.get(character);
            if (value == null) {
                levelNode.children.put(character, new Node(character));
            } else {
                levelNode.children.get(character).occurrenceCount++;
            }
            levelNode = levelNode.children.get(character);
        }
        levelNode.isEnd = true;
    }

    // O(L); L = length of word
    public void remove(String w) {
        if (w == null) {
            throw new IllegalArgumentException("Invalid word");
        }
        String word = w.toLowerCase();
        if (!this.contains(word)) {
            return;
        }
        var levelNode = this.root;
        for (var character : word.toCharArray()) {
            var value = levelNode.children.get(character);
            if (value == null) {
                throw new IllegalStateException(String.format("No such word `%s`", word));
            }
            if (value.occurrenceCount == 1) {
                levelNode.children.remove(character);
            } else {
                value.occurrenceCount--;
            }
            levelNode = value;
        }
        if (!levelNode.isEnd) {
            throw new IllegalStateException(String.format("No such word `%s`", word));
        }
    }

    // O(L); L = length of word
    public boolean contains(String w) {
        if (w == null) {
            throw new IllegalArgumentException("Invalid word");
        }
        String word = w.toLowerCase();
        var levelNode = this.root;
        for (var character : word.toCharArray()) {
            var value = levelNode.children.get(character);
            if (value == null) {
                return false;
            }
            levelNode = value;
        }
        return levelNode.isEnd;
    }

}
