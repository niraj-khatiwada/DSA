package Trie;

public class TrieUsingArray {
    private class Node {
        public char value;
        public boolean isEnd;
        public Node[] children;

        public Node() {
            this.isEnd = false;
            this.children = new Node[26];
        }

        public Node(char value) {
            this.value = value;
            this.isEnd = false;
            this.children = new Node[26];
        }
    }

    private class Trie {
        public Node root;

        public Trie() {
            this.root = new Node();
        }

        public void add(String word) {
            var i = 0;
            var current = this.root;
            while (i < word.length()) {
                var ch = word.charAt(i);
                var chi = ch - 'a';
                if (current.children[chi] == null) {
                    current.children[chi] = new Node(ch);
                }
                i++;
                current = current.children[chi];
            }
            current.isEnd = true;
        }

        public Node containsPrefix(String word) {
            var i = 0;
            var current = this.root;
            while (i < word.length()) {
                var ch = word.charAt(i);
                var chi = ch - 'a';
                if (current.children[chi] == null) {
                    return null;
                }
                i++;
                current = current.children[chi];
            }
            return current;
        }

        public void remove(String word) {
            this._remove(this.root, word, 0);
        }

        private void _remove(Node node, String word, int i) {
            if (i > word.length()) {
                return;
            }

            if (i == word.length() && node.isEnd) {
                node.isEnd = false;
                return;
            }

            var ch = word.charAt(i);
            var chi = ch - 'a';
            var child = node.children[chi];

            _remove(child, word, i + 1);

            var hasChildren = false;
            for (var j = 0; j < 26; j++) {
                if (child.children[j] != null) {
                    hasChildren = true;
                    break;
                }
            }
            if (!hasChildren) {
                node.children[chi] = null;
            }
        }

    }
}
