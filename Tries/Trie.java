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
        return _remove(this.root, word, 0, null);
    }

    public boolean _remove(Node node, String word, int i, Node parent) {
        if (node == null) {
            return false;
        }
        if (i < word.length()) {
            var child = node.children.get(word.charAt(i));
            if (child == null) {
                return false;
            }
            if (i == (word.length() - 1)) {
                if (!child.isEnd) {
                    return false;
                }
                child.isEnd = false;
            }
            _remove(child, word, i + 1, node);
        }

        if (node.children.size() == 0) {
            parent.children.remove(node.value);
        }

        return true;
    }

    public List<String> autocomplete(String word) {
        var list = new ArrayList<String>();
        this._autocomplete(this.root, word, 0, new StringBuilder(), list);
        return list;
    }

    private void _autocomplete(Node node, String word, int i, StringBuilder s, List<String> list) {
        // First match given word
        if (i >= 0 && i < word.length()) {
            var child = node.children.get(word.charAt(i));
            // Word exceeded
            if (child == null) {
                return;
            }
            s.append(child.value);
            _autocomplete(child, word, i + 1, new StringBuilder(s), list);
        } else {
            // Match all remaining children
            if (i == -1) {
                s.append(node.value);
            }
            if (node.isEnd) {
                list.add(s.toString());
                if (node.children.size() == 0) {
                    return;
                }
            }
            for (var entry : node.children.entrySet()) {
                _autocomplete(entry.getValue(), word, -1, new StringBuilder(s), list);
            }
        }
        return;
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
