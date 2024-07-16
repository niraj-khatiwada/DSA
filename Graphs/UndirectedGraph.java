package Graphs;

import java.util.HashMap;
import java.util.LinkedList;

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