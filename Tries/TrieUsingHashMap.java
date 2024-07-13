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

    public boolean containsUsingRecursion(String w) {
        String word = w.toLowerCase();
        String prefix = new String();
        return _containsAccumulator(this.root, prefix, word);
    }

    private boolean _containsAccumulator(Node node, String prefix, String word) {
        if (node == null) {
            return false;
        }
        if (node.isLast) {
            return prefix.equals(word);
        }
        for (var child : node.children.entrySet()) {
            var childNode = child.getValue();
            if (childNode != null) {
                if (_containsAccumulator(childNode, prefix + childNode.value, word)) {
                    return true;
                }
            }
        }
        return false;
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

    public int countWords() {
        return this._countWords(this.root, 0);

    }

    private int _countWords(Node node, int count) {
        if (node == null) {
            return 0;
        }
        if (node.isLast) {
            return 1;
        }
        for (var child : node.children.entrySet()) {
            if (node != null) {
                count += _countWords(child.getValue(), 0);
            }
        }

        return count;
    }

    public String longestCommonPrefix() {
        return this._longestCommonPrefix(this.root, "");

    }

    private String _longestCommonPrefix(Node node, String prefix) {
        if (node == null || node.isLast) {
            return prefix;
        }

        if (node.children.size() > 1) {
            return prefix;
        }
        for (var child : node.children.entrySet()) {
            if (child != null) {
                prefix = _longestCommonPrefix(child.getValue(), prefix + child.getKey());
            }
        }

        return prefix;
    }

}
