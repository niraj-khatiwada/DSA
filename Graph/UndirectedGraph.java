package Graph;

import java.util.*;

public class UndirectedGraph {
    private class NodeEntry {
        public Node node;
        public int distance;

        public NodeEntry(Node node) {
            this.node = node;
        }

        public NodeEntry(Node node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    private class Node {
        public String value;
        public List<Edge> edges;

        public Node(String value) {
            this.value = value;
            this.edges = new LinkedList<>();
        }

        public void addEdge(Node to, int weight) {
            this.edges.add(new Edge(this, to, weight));
            to.edges.add(new Edge(to, this, weight));
        }

        public void removeEdge(Node to) {
            Edge fromEdge = null;
            for (var edge : this.edges) {
                if (edge.from == this && edge.to == to) {
                    fromEdge = edge;
                    break;
                }

            }
            if (fromEdge != null) {
                System.out.printf("REMOVING %s from %s\n", fromEdge.to.value, fromEdge.from.value);
                this.edges.remove(fromEdge);
            }
            Edge toEdge = null;
            for (var edge : to.edges) {
                if (edge.from == to && edge.to == this) {
                    toEdge = edge;
                    break;
                }

            }
            if (toEdge != null) {
                System.out.printf("REMOVING %s from %s\n", toEdge.to.value, toEdge.from.value);
                to.edges.remove(toEdge);
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

    public HashMap<String, Node> graph;

    public UndirectedGraph() {
        this.graph = new HashMap<>();
    }

    public void addNode(String value) {
        if (this.graph.get(value) == null) {
            this.graph.put(value, new Node(value));
        }
    }

    public Node removeNode(String value) {
        var node = this.graph.get(value);
        if (node == null) {
            return null;
        }
        var edges = node.edges;
        while (!edges.isEmpty()) {
            node.removeEdge(edges.get(0).to);
        }
        this.graph.remove(value);
        return node;

    }

    public void addEdge(String from, String to, int weight) {
        var fromNode = this.graph.get(from);
        if (fromNode == null) {
            throw new IllegalStateException("Invalid from value");
        }
        var toNode = this.graph.get(to);
        if (toNode == null) {
            throw new IllegalStateException("Invalid to value");
        }
        fromNode.addEdge(toNode, weight);
    }

    public void removeEdge(String from, String to) {
        var fromNode = this.graph.get(from);
        if (fromNode == null) {
            throw new IllegalStateException("Invalid from value");
        }
        var toNode = this.graph.get(to);
        if (toNode == null) {
            throw new IllegalStateException("Invalid to value");
        }
        fromNode.removeEdge(toNode);
    }

    public Object[] shortestPath(String from, String to) {
        var nodeDistance = new HashMap<String, Integer>();
        var nodeParent = new HashMap<String, Node>();
        for (var entry : this.graph.entrySet()) {
            var key = entry.getKey();
            nodeDistance.put(key, Integer.MAX_VALUE);
            nodeParent.put(key, null);
        }
        var visited = new HashSet<String>();
        var queue = new PriorityQueue<NodeEntry>(Comparator.comparingInt(x -> x.distance));
        queue.offer(new NodeEntry(this.graph.get(from)));
        while (!queue.isEmpty()) {
            var current = queue.poll();
            visited.add(current.node.value);
            for (var edge : current.node.edges) {
                var toVal = edge.to.value;
                if (visited.contains(toVal)) {
                    continue;
                }
                var previousMinDistance = nodeDistance.get(toVal);
                var newMin = Math.min(previousMinDistance, (edge.weight + current.distance));
                if (newMin < previousMinDistance) {
                    nodeDistance.put(toVal, newMin);
                    nodeParent.put(toVal, current.node);
                    queue.add(new NodeEntry(edge.to, newMin));
                }
            }
        }
        var path = new StringBuilder(to);
        var c = to;
        while (true) {
            var parent = nodeParent.get(c);
            if (parent == null) {
                break;

            }
            path.append(parent.value);
            c = parent.value;
        }
        // [Min Distance, Path]
        return new Object[] { nodeDistance.get(to), path.toString() };

    }

}
