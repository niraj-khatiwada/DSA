package Tries;

import java.util.HashMap;
import java.util.ArrayList;

public class TrieUsingHashMap {
    private class Node {
        public char value;
        public HashMap<Character, Node> children;
        public int occurrenceCount;
        public boolean isLast = false;

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
    public void add(String w) {
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
        levelNode.isLast = true;
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
        if (!levelNode.isLast) {
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
        return levelNode.isLast;
    }

    public ArrayList<String> autocomplete(String w) {
        var matched = new ArrayList<String>();
        if (w == null) {
            return matched;
        }
        String word = w.toLowerCase();

        var levelNode = this.root;
        var prefix = new String();
        for (var character : word.toCharArray()) {
            var value = levelNode.children.get(character);
            if (value == null) {
                return matched;
            }
            prefix += character;
            levelNode = value;
        }
        if (levelNode.isLast) {
            matched.add(word);
            return matched;
        }
        _accumulator(levelNode, prefix, matched);
        return matched;

    }

    private void _accumulator(Node node, String prefix, ArrayList<String> accumulator) {
        if (node == null) {
            return;
        }

        if (node.isLast) {
            accumulator.add(prefix);
            return;
        }

        for (var child : node.children.entrySet()) {
            var childChar = child.getKey();
            var childNode = child.getValue();
            _accumulator(childNode, prefix + childChar, accumulator);
        }

    }

}
