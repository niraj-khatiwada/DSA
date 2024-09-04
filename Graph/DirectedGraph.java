package Graph;

import java.util.*;

public class DirectedGraph {
    private class Edge {
        public Node to;
        public int weight;

        public Edge(Node to) {
            this.to = to;
        }
    }

    private class Node {
        public int value;
        public List<Edge> edges;

        public Node(int value) {
            this.value = value;
            this.edges = new ArrayList<>();
        }
    }

    public Map<Integer, Node> graph = new HashMap<>();

    // O(1)
    public void addNode(int value) {
        if (graph.containsKey(value)) {
            return;
        }
        graph.put(value, new Node(value));
    }

    // O(v); v = number of vertices
    public void addEdge(int from, int to) {
        var fromNode = graph.get(from);
        if (fromNode == null) {
            throw new IllegalArgumentException("from node does not exit");
        }
        var toNode = graph.get(to);
        if (toNode == null) {
            throw new IllegalArgumentException("to node does not exit");
        }
        var exists = false;
        for (var edge : fromNode.edges) {
            if (edge.to.value == to) {
                exists = true;
                break;
            }
        }
        if (!exists) {
            fromNode.edges.add(new Edge(toNode));
        }
    }

    // O(v)
    public void removeEdge(int from, int to) {
        var fromNode = graph.get(from);
        if (fromNode == null) {
            throw new IllegalArgumentException("from node does not exit");
        }
        var toNode = graph.get(to);
        if (toNode == null) {
            throw new IllegalArgumentException("to node does not exit");
        }
        Edge ed = null;
        for (var edge : fromNode.edges) {
            if (edge.to.value == to) {
                ed = edge;
                break;
            }
        }
        if (ed != null) {
            fromNode.edges.add(ed);
        }
    }

    // O(v ^ 2)
    public void removeNode(int value) {
        var node = graph.get(value);
        if (node == null) {
            return;
        }
        for (var entry : graph.entrySet()) {
            if (entry.getKey() != value) {
                var edges = entry.getValue().edges;
                Edge edg = null;
                for (var edge : edges) {
                    if (edge.to.value == value) {
                        edg = edge;
                        break;
                    }
                }
                if (edg != null) {
                    edges.remove(edg);
                }
            }
        }
    }

    // O(v)
    public List<Integer> findNeighbors(int value) {
        var neighbors = new ArrayList<Integer>();
        var node = graph.get(value);
        if (node == null) {
            return neighbors;
        }
        for (var edge : node.edges) {
            neighbors.add(edge.to.value);
        }
        return neighbors;
    }

    public void bfs(int start) {
        var node = graph.get(start);
        if (node == null) {
            return;
        }
        var visited = new HashSet<Integer>();
        var queue = new ArrayDeque<Node>();
        queue.add(node);
        while (!queue.isEmpty()) {
            var size = queue.size();
            for (var i = 0; i < size; i++) {
                var pop = queue.poll();
                if (visited.contains(pop.value)) {
                    continue;
                }
                visited.add(pop.value);
                System.out.println(pop.value);
                for (var edge : pop.edges) {
                    queue.add(edge.to);
                }
            }
        }
    }

    // parent-to-child
    public void preOrderDfs(int start) {
        var node = graph.get(start);
        if (node == null) {
            return;
        }
        var visited = new HashSet<Integer>();
        this._preOrderDfs(node, visited);
    }

    private void _preOrderDfs(Node node, Set<Integer> visited) {
        if (node == null || visited.contains(node.value)) {
            return;
        }
        System.out.println(node.value);
        visited.add(node.value);
        for (var edge : node.edges) {
            _preOrderDfs(edge.to, visited);
        }
    }

    public void postOrderDfs(int start) {
        var node = graph.get(start);
        if (node == null) {
            return;
        }
        var visited = new HashSet<Integer>();
        this.postOrderDfs(node, visited);
    }

    // children-to-parent
    private void postOrderDfs(Node node, Set<Integer> visited) {
        if (node == null || visited.contains(node.value)) {
            return;
        }
        for (var edge : node.edges) {
            postOrderDfs(edge.to, visited);
        }
        System.out.println(node.value);
        visited.add(node.value);
    }

    public void preOrderDFSUsingStack(int start) {
        var node = graph.get(start);
        if (node == null) {
            return;
        }
        var visited = new HashSet<Integer>();
        var stack = new Stack<Node>();
        stack.add(node);
        while (!stack.isEmpty()) {
            var size = stack.size();
            for (var i = 0; i < size; i++) {
                var pop = stack.pop();
                if (visited.contains(pop.value)) {
                    continue;
                }
                visited.add(pop.value);
                System.out.println(pop.value);
                for (var edge : pop.edges) {
                    stack.add(edge.to);
                }
            }
        }
    }

    public void postOrderDFSUsingStack(int start) {
        var node = graph.get(start);
        if (node == null) {
            return;
        }
        var visited = new HashSet<Integer>();
        var stack1 = new Stack<Node>();
        stack1.add(node);
        var stack2 = new Stack<Integer>();

        while (!stack1.isEmpty()) {
            var pop = stack1.pop();
            if (visited.contains(pop.value)) {
                continue;
            }
            visited.add(pop.value);
            stack2.push(pop.value);
            for (var edge : pop.edges) {
                stack1.push(edge.to);
            }
        }

        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop());
        }
    }

    public void print() {
        for (var entry : this.graph.entrySet()) {
            var key = entry.getKey();
            System.out.printf("%s\n", key);
            for (var edge : entry.getValue().edges) {
                System.out.printf("%s->%s\n", key, edge.to.value);
            }
        }
    }
}
