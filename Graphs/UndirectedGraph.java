package Graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Stack;

public class UndirectedGraph {
    private class Node {
        public String value;
        public LinkedList<Edge> edges;

        public Node(String value) {
            this.value = value;
            this.edges = new LinkedList<>();
        }

        public void addEdge(Node to, int weight) {
            var edge = new Edge(this, to, weight);

            if (!edges.contains(edge)) {
                edges.add(edge);
            }
        }

    }

    private class Edge {
        public Node from;
        public Node to;
        public int weight;

        public Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    private class NodeEntry {
        public Node node;
        public int priority;

        public NodeEntry(Node node, int priority) {
            this.node = node;
            this.priority = priority;
        }
    }

    public HashMap<String, Node> nodes;

    public UndirectedGraph() {
        this.nodes = new HashMap<>();
    }

    public void addNode(String value) {
        if (this.nodes.containsKey(value)) {
            return;
        }
        var newNode = new Node(value);
        this.nodes.put(value, newNode);
    }

    public void addEdge(String from, String to, int weight) {
        var fromNode = this.nodes.get(from);
        if (fromNode == null) {
            throw new IllegalArgumentException("from node does not exist.");
        }

        var toNode = this.nodes.get(to);
        if (toNode == null) {
            throw new IllegalArgumentException("to node does not exist.");
        }
        fromNode.addEdge(toNode, weight);
        toNode.addEdge(fromNode, weight);

    }

    public ArrayList<String> findShortestPath(String from, String to) {
        var fromNode = this.nodes.get(from);
        if (fromNode == null) {
            throw new IllegalArgumentException("fromNode does not exist.");
        }
        var toNode = this.nodes.get(to);
        if (toNode == null) {
            throw new IllegalArgumentException("toNode node does not exist.");
        }
        var nodeDistances = new HashMap<Node, Integer>();
        var nodeParents = new HashMap<Node, Node>();
        var queue = new PriorityQueue<NodeEntry>(Comparator.comparingInt(x -> x.priority));
        var set = new HashSet<Node>();

        for (var entry : this.nodes.entrySet()) {
            var node = entry.getValue();
            nodeDistances.put(node, entry.getKey() == from ? 0 : Integer.MAX_VALUE);
            nodeParents.put(node, null);
        }

        queue.add(new NodeEntry(fromNode, 0));

        while (!queue.isEmpty()) {
            var nodeEntry = queue.remove();
            if (set.contains(nodeEntry.node)) {
                continue;
            }
            set.add(nodeEntry.node);

            for (var edge : nodeEntry.node.edges) {
                if (!set.contains(edge.to)) {
                    var lastDistance = nodeDistances.get(nodeEntry.node);
                    var distance = edge.weight + (lastDistance.equals(Integer.MAX_VALUE) ? 0
                            : lastDistance);
                    if (distance < nodeDistances.get(edge.to)) {
                        nodeDistances.put(edge.to, distance);
                        nodeParents.put(edge.to, nodeEntry.node);
                    }
                    queue.add(new NodeEntry(edge.to, distance));
                }
            }
        }
        var currentNode = toNode;
        var stack = new Stack<String>();

        while (currentNode != null) {
            stack.add(currentNode.value);
            var parentNode = nodeParents.get(currentNode);
            if (parentNode == null) {
                break;
            }
            currentNode = parentNode;
        }
        var shortestPath = new ArrayList<String>();
        while (!stack.isEmpty()) {
            shortestPath.add(stack.pop());

        }
        return shortestPath;

    }

    public boolean hasCycle() {
        for (var entry : this.nodes.entrySet()) {
            var visited = new HashSet<String>();
            var visiting = new HashSet<String>();
            var cycle = new ArrayList<String>();
            var node = entry.getValue();
            if (this._hasCycle(node, visited, visiting, null, cycle)) {
                System.out.println(cycle);
                return true;
            }
        }

        return false;
    }

    private boolean _hasCycle(Node node, HashSet<String> visited, HashSet<String> visiting, Node parentNode,
            ArrayList<String> cycle) {
        if (visited.contains(node.value)) {
            return false;
        }

        cycle.add(node.value);

        if (visiting.contains(node.value)) {
            return true;
        }

        visiting.add(node.value);
        for (var edge : node.edges) {
            if (!visited.contains(edge.to.value)) {
                if (parentNode != null && parentNode.value.equals(edge.to.value))
                    continue;
                if (_hasCycle(edge.to, visited, visiting, node, cycle)) {
                    return true;
                }
            }
        }
        visited.add(node.value);
        visiting.remove(node.value);

        return false;
    }

    // Prim's algorithm
    public void minimumSpanningTree(String start) {
        var startNode = this.nodes.get(start);
        if (startNode == null) {
            throw new IllegalArgumentException("startNode does not exist.");
        }
        var visited = new HashSet<String>();
        var path = new ArrayList<String>();

        var currentNode = startNode;
        while (currentNode != null) {
            var queue = new PriorityQueue<NodeEntry>(Comparator.comparingInt(x -> x.priority));
            for (var edge : currentNode.edges) {
                var node = edge.to;
                if (!visited.contains(node.value)) {
                    queue.add(new NodeEntry(node, edge.weight));
                }
            }
            visited.add(currentNode.value);
            path.add(currentNode.value);

            if (queue.isEmpty()) {
                break;
            }
            currentNode = queue.remove().node;
        }

        System.out.println(path);

    }

    public void print() {
        for (var entry : this.nodes.entrySet()) {
            var key = entry.getKey();
            var node = entry.getValue();
            System.out.println(String.format("Node = %s", key));
            for (var edge : node.edges) {
                System.out
                        .println(String.format("%s -> %s with weight %s", edge.from.value, edge.to.value,
                                edge.weight));
            }
            System.out.printf("\n");
        }
    }

}