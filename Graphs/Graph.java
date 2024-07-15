package Graphs;

import java.util.LinkedList;
import java.util.HashMap;
import java.util.HashSet;

public class Graph {
    private class Node {
        public String label;

        public Node(String label) {
            this.label = label;
        }
    }

    public HashMap<String, LinkedList<Node>> labelNodes;

    public Graph() {
        this.labelNodes = new HashMap<>();
    }

    public void addNode(String label) {
        if (this.labelNodes.containsKey(label)) {
            return;
        }
        this.labelNodes.put(label, new LinkedList<Node>());
    }

    public void addEdge(String from, String to) {
        var fromList = this.labelNodes.get(from);
        if (fromList == null) {
            throw new IllegalArgumentException(String.format("Label `%s` does not exist.", from));
        }
        var toList = this.labelNodes.get(to);
        if (toList == null) {
            throw new IllegalArgumentException(String.format("Label `%s` does not exist.", to));
        }
        for (var node : fromList) {
            if (node.label.equals(to)) {
                return;
            }
        }
        fromList.add(new Node(to));
    }

    public void removeEdge(String from, String to) {
        var fromList = this.labelNodes.get(from);
        if (fromList == null) {
            throw new IllegalArgumentException(String.format("Label `%s` does not exist.", from));
        }
        if (!this.labelNodes.containsKey(to)) {
            throw new IllegalArgumentException(String.format("Label `%s` does not exist.", to));
        }
        for (var node : fromList) {
            if (node.label.equals(to)) {
                fromList.remove(node);
                return;
            }
        }
        throw new IllegalArgumentException(String.format("Label `%s` is not linked to label %s.", to, from));
    }

    public void removeNode(String label) {
        if (!this.labelNodes.containsKey(label)) {
            throw new IllegalArgumentException(String.format("Label `%s` does not exist.", label));
        }
        for (var entry : this.labelNodes.entrySet()) {
            var _label = entry.getKey();
            var list = entry.getValue();
            if (!label.equals(_label)) {
                for (var node : list) {
                    if (node.label.equals(label)) {
                        list.remove(node);
                    }
                }
            }
        }
        this.labelNodes.remove(label);
    }

    public void depthFirstTraversal(String label) {
        var set = new HashSet<String>();
        var nodes = this.labelNodes.get(label);
        if (nodes == null) {
            throw new IllegalArgumentException(String.format("Label `%s` does not exist.", label));
        }
        this._depthFirstTraversal(label, set);
    }

    private void _depthFirstTraversal(String label, HashSet<String> set) {
        System.out.println(label);
        set.add(label);
        for (var node : this.labelNodes.get(label)) {
            if (!set.contains(node.label)) {
                _depthFirstTraversal(node.label, set);
            }
        }

    }

    public void print() {
        for (var entry : this.labelNodes.entrySet()) {
            String label = entry.getKey();
            System.out.printf("-%s\n", label);
            for (var node : entry.getValue()) {
                System.out.printf("-%s is linked to %s\n", label, node.label);
            }
        }
    }

}