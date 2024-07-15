package Graphs;

import java.util.LinkedList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;
import java.util.ArrayDeque;

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

    public void depthFirstTraversalUsingRecursion(String label) {
        var nodes = this.labelNodes.get(label);
        if (nodes == null) {
            throw new IllegalArgumentException(String.format("Label `%s` does not exist.", label));
        }
        var set = new HashSet<String>();
        this._depthFirstTraversalUsingRecursion(label, set);
    }

    private void _depthFirstTraversalUsingRecursion(String label, HashSet<String> set) {
        System.out.println(label);
        set.add(label);
        for (var node : this.labelNodes.get(label)) {
            if (!set.contains(node.label)) {
                _depthFirstTraversalUsingRecursion(node.label, set);
            }
        }

    }

    public void depthFirstTraversalUsingIteration(String label) {
        var nodes = this.labelNodes.get(label);
        if (nodes == null) {
            throw new IllegalArgumentException(String.format("Label `%s` does not exist.", label));
        }
        var set = new HashSet<String>();
        var stack = new Stack<String>();
        stack.push(label);

        // Using a stack, we'll make sure that we visited a parent and it's
        // children(neighbors) before visiting other nodes. We pop the parent and push
        // its' children immediately.
        while (!stack.isEmpty()) {
            var current = stack.pop();
            if (set.contains(current)) {
                continue;
            }
            System.out.println(current);
            set.add(current);

            for (var node : this.labelNodes.get(current)) {
                if (!set.contains(node.label)) {
                    stack.add(node.label);
                }
            }
        }
    }

    public void breadthFirstTraversal(String label) {
        var nodes = this.labelNodes.get(label);
        if (nodes == null) {
            throw new IllegalArgumentException(String.format("Label `%s` does not exist.", label));
        }
        var set = new HashSet<String>();
        var queue = new ArrayDeque<String>();
        queue.push(label);

        // Using a queue, we'll make sure that we visit it's neighbor first
        while (!queue.isEmpty()) {
            var current = queue.remove();
            if (set.contains(current)) {
                continue;
            }
            System.out.println(current);
            set.add(current);

            for (var node : this.labelNodes.get(current)) {
                if (!set.contains(node.label)) {
                    queue.add(node.label);
                }
            }
        }
    }

    // We need to make sure we properly add the node first to do this sorting. Use
    // example `TopologicalSorting.png` or:
    /*
     * var graph = new Graph();
     * graph.addNode("Z");
     * graph.addNode("P");
     * graph.addNode("X");
     * graph.addNode("B");
     * graph.addNode("A");
     * 
     * graph.addEdge("X", "A");
     * graph.addEdge("A", "P");
     * graph.addEdge("B", "P");
     * graph.addEdge("X", "B");
     * graph.addEdge("Z", "X");
     */;

    public void topologicalSorting() {
        var set = new HashSet<String>();
        var stack = new Stack<String>();
        for (var entry : this.labelNodes.entrySet()) {
            var label = entry.getKey();
            this._topologicalSorting(label, set, stack);
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }

    private void _topologicalSorting(String label, HashSet<String> set, Stack<String> stack) {
        if (set.contains(label)) {
            return;
        }
        set.add(label);
        // And it's children
        var nodes = this.labelNodes.get(label);
        for (var node : nodes) {
            if (!set.contains(node.label)) {
                _topologicalSorting(node.label, set, stack);
            }
        }
        // Post Order Traversal. We need to first go through children and then come back
        // to parent.
        stack.push(label);

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