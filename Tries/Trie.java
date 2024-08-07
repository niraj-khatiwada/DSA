package Tries;

import java.util.*;

public class Trie {
    private class Node {
        public char value;
        public HashMap<Character, Node> children;
        public boolean isEnd;

        public Node() {
            this.children = new HashMap<>();
        }

        public Node(char value) {
            this.value = value;
            this.children = new HashMap<>();
        }
    }

    public Node root;

    public Trie() {
        this.root = new Node();
    }

    public void add(String word) {
        var current = this.root;
        var characters = word.toCharArray();
        for (var i = 0; i < characters.length; i++) {
            var ch = characters[i];
            var val = current.children.get(ch);
            if (val == null) {
                var node = new Node(ch);
                if (i == (characters.length - 1)) {
                    node.isEnd = true;
                }
                current.children.put(ch, node);
            }
            current = current.children.get(ch);
        }
    }

    public boolean remove(String word) {
        return _remove(this.root, word, 0);
    }

    public boolean _remove(Node node, String word, int index) {
        if (index == (word.length())) {
            var ch = word.charAt(index - 1);
            if (!node.isEnd) {
                return false;
            }
            // The last character must match
            // For example, cat, car can lead to same place
            if (ch == node.value) {
                node.isEnd = false;
            }
            return true;
        }
        for (var entry : node.children.entrySet()) {
            _remove(entry.getValue(), word, index + 1);
        }
        var ch = word.charAt(index);
        var child = node.children.get(ch);
        if (child == null) {
            return false;
        }
        if (!child.isEnd && child.children.size() == 0) {
            node.children.remove(ch);
        }
        return true;
    }

    public void dfsPreOrder() {
        this._dfsPreOrder(this.root);
    }

    public void _dfsPreOrder(Node node) {
        if (node.value != 32) {
            System.out.println(node.value);
        }
        if (node.isEnd) {
            return;
        }
        for (var entry : node.children.entrySet()) {
            _dfsPreOrder(entry.getValue());
        }
    }

    public void dfsPostOrder() {
        this._dfsPostOrder(this.root);
    }

    public void _dfsPostOrder(Node node) {
        for (var entry : node.children.entrySet()) {
            _dfsPostOrder(entry.getValue());
        }
        if (node.value != 32) {
            System.out.println(node.value);
        }
        if (node.isEnd) {
            return;
        }
    }

    public void print() {
        var str = new StringBuilder();
        this._print(this.root, str);
    }

    public void _print(Node node, StringBuilder str) {
        if (node.value != 32) {
            str.append(node.value);
        }
        if (node.isEnd) {
            System.out.println(str.toString());
            if (node.children.size() == 0) {
                return;
            }
        }
        for (var entry : node.children.entrySet()) {
            _print(entry.getValue(), new StringBuilder(str));
        }
    }
}
