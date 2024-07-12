package Tries;

import java.util.ArrayList;

public class TrieUsingArray {
    private class Node {
        public char value;
        public Node[] children;
        public int occurrenceCount;
        public boolean isLast = false;

        public Node() {
            this.children = new Node[26];
        }

        public Node(char value) {
            this.value = value;
            this.children = new Node[26];
            this.occurrenceCount = 1;
        }

    }

    public Node root;

    public TrieUsingArray() {
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
            int charIndex = character - 'a';
            var value = levelNode.children[charIndex];
            if (value == null) {
                levelNode.children[charIndex] = new Node(character);
            } else {
                levelNode.children[charIndex].occurrenceCount++;
            }
            levelNode = levelNode.children[charIndex];
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
            int charIndex = character - 'a';
            var value = levelNode.children[charIndex];
            if (value == null) {
                throw new IllegalStateException(String.format("No such word `%s`", word));
            }
            if (value.occurrenceCount == 1) {
                levelNode.children[charIndex] = null;
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
            var charIndex = character - 'a';
            var value = levelNode.children[charIndex];
            if (value == null) {
                return false;
            }
            levelNode = levelNode.children[charIndex];
        }
        return levelNode.isLast;
    }

    public ArrayList<String> autocomplete(String w) {
        var word = w.toLowerCase();
        var levelNode = this.root;
        var matched = new ArrayList<String>();
        var prefix = new String();
        for (var character : word.toCharArray()) {
            int charIndex = character - 'a';
            var value = levelNode.children[charIndex];
            if (value == null) {
                return matched;
            }
            levelNode = levelNode.children[charIndex];
            prefix += character;
        }
        if (levelNode.isLast) {
            matched.add(word);
            return matched;
        }
        this._accumulator(levelNode, prefix, matched);
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
        for (var child : node.children) {
            if (child != null) {
                _accumulator(child, prefix + child.value, accumulator);
            }
        }
    }
}