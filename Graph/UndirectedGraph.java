package Graph;

import java.util.*;

public class UndirectedGraph {

    private class NodeEntry {
        public Node node;
        public int weight;

        public NodeEntry(Node node, int weight) {
            this.node = node;
            this.weight = weight;
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
    public void addEdge(int from, int to, int weight) {
        var fromNode = graph.get(from);
        if (fromNode == null) {
            throw new IllegalArgumentException("from node does not exist");
        }
        var toNode = graph.get(to);
        if (toNode == null) {
            throw new IllegalArgumentException("to node does not exist");
        }
        var exists = false;
        for (var edge : fromNode.edges) {
            if (edge.to.value == to) {
                exists = true;
                break;
            }
        }
        if (!exists) {
            fromNode.edges.add(new Edge(fromNode, toNode, weight));
            toNode.edges.add(new Edge(toNode, fromNode, weight));
        }
    }

    // O(v)
    public void removeEdge(int from, int to) {
        var fromNode = graph.get(from);
        if (fromNode == null) {
            throw new IllegalArgumentException("from node does not exist");
        }
        var toNode = graph.get(to);
        if (toNode == null) {
            throw new IllegalArgumentException("to node does not exist");
        }
        Edge ed = null;
        for (var edge : fromNode.edges) {
            if (edge.to.value == to) {
                ed = edge;
                break;
            }
        }
        if (ed != null) {
            fromNode.edges.remove(ed);
            toNode.edges.remove(ed);
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
    // O(v+e)
    public void preOrderDfs(int start) {
        var node = graph.get(start);
        if (node == null) {
            return;
        }
        var visited = new HashSet<Integer>();
        this._preOrderDfs(node, visited);
        for (var entry : graph.entrySet()) {
            if (entry.getValue() != node) {
                this._preOrderDfs(entry.getValue(), visited);
            }
        }
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

    // children-to-parent
    // O(v+e)
    public void postOrderDfs(int start) {
        var node = graph.get(start);
        if (node == null) {
            return;
        }
        var visited = new HashSet<Integer>();
        this._postOrderDfs(node, visited);
        for (var entry : graph.entrySet()) {
            if (entry.getValue() != node) {
                this._postOrderDfs(entry.getValue(), visited);
            }
        }
    }

    private void _postOrderDfs(Node node, Set<Integer> visited) {
        if (node == null || visited.contains(node.value)) {
            return;
        }
        for (var edge : node.edges) {
            _postOrderDfs(edge.to, visited);
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
        _preOrderDFSUsingStack(stack, visited);
        for (var entry : graph.entrySet()) {
            var n = entry.getValue();
            if (n != node) {
                stack.add(n);
                this._preOrderDFSUsingStack(stack, visited);
            }
        }

    }

    private void _preOrderDFSUsingStack(Stack<Node> stack, Set<Integer> visited) {
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
        this._postOrderDFSUsingStack(stack1, stack2, visited);
        for (var entry : graph.entrySet()) {
            var n = entry.getValue();
            if (n != node) {
                stack1.add(n);
                this._postOrderDFSUsingStack(stack1, stack2, visited);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop());
        }

    }

    private void _postOrderDFSUsingStack(Stack<Node> stack1, Stack<Integer> stack2, Set<Integer> visited) {
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
    }

    // O(v+e)
    public boolean pathExists(int from, int to) {
        var fromNode = graph.get(from);
        if (fromNode == null) {
            throw new IllegalArgumentException("from node does not exist");
        }
        var toNode = graph.get(to);
        if (toNode == null) {
            throw new IllegalArgumentException("to node does not exist");
        }
        var visited = new HashSet<Integer>();
        return this._pathExists(fromNode, toNode, visited);
    }

    private boolean _pathExists(Node node, Node target, Set<Integer> visited) {
        if (node == null || visited.contains(node.value)) {
            return false;
        }
        if (node.value == target.value) {
            return true;
        }
        visited.add(node.value);
        for (var edge : node.edges) {
            if (_pathExists(edge.to, target, visited)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle() {
        var visited = new HashSet<Integer>();
        for (var entry : graph.entrySet()) {
            var visiting = new HashSet<Integer>();
            var path = new HashMap<Integer, Node>();
            var res = this._hasCycle(entry.getValue(), null, visiting, path);
            if ((boolean) res[0]) {
                var point = (Node) res[1];
                var parent = (Node) res[2];
                System.out.printf("Found circular at %s -> %s\n", parent.value, point.value);
                var str = new StringBuilder();
                str.append(point.value + " <- " + parent.value);
                while (parent != null) {
                    parent = path.get(parent.value);
                    if (parent != null) {
                        str.append(" <- " + parent.value);
                    }
                }
                System.out.println(str);
                return true;
            }
            visited.addAll(visiting);
        }
        return false;
    }

    private Object[] _hasCycle(Node node, Node parent, Set<Integer> visiting, Map<Integer, Node> path) {
        if (node == null) {
            return new Object[] { false, null, null };
        }
        if (visiting.contains(node.value)) {
            return new Object[] { true, node, parent };
        }
        path.put(node.value, parent);
        visiting.add(node.value);
        for (var edge : node.edges) {
            if (edge.to != parent) {
                var res = _hasCycle(edge.to, node, visiting, path);
                if ((boolean) res[0]) {
                    return res;
                }
            }
        }
        return new Object[] { false, null, null };
    }

    // Graph Coloring
    // O(v+e), since we are just doing BFS
    // SC: O(v) for extra queue and colors
    // Acyclic graphs are bipartite
    // Cyclic graph with even number of nodes in the cycle are bipartite as well.
    // Cyclic graph with odd number of nodes in the cycle re not bipartite.
    // (NOTE:Not the nodes n=in the whole graph, but the number of nodes making up
    // the cycle. We've done this in hasCycle() method to get the nodes consisting
    // the cycle.)
    public boolean isBipartite() {
        var colors = new HashMap<Integer, Integer>(); // 1 = Blue, 2 = Red
        var queue = new ArrayDeque<Node>();
        for (var entry : graph.entrySet()) {
            var node = entry.getValue();
            queue.add(node);
            if (colors.get(node.value) == null) {
                colors.put(node.value, 1); // Make first node blue
            }
            if (!this._isBipartiteBFS(queue, colors)) {
                System.out.println(colors);
                return false;
            }
        }
        return true;
    }

    private boolean _isBipartiteBFS(Queue<Node> queue, Map<Integer, Integer> colors) {
        while (!queue.isEmpty()) {
            var size = queue.size();
            for (var i = 0; i < size; i++) {
                var pop = queue.poll();
                var parentColor = colors.get(pop.value);
                for (var edge : pop.edges) {
                    var childColor = colors.get(edge.to.value);
                    if (childColor != null) {
                        if (childColor == parentColor) {
                            return false;
                        }
                    } else {
                        colors.put(edge.to.value, parentColor == 1 ? 2 : 1);
                        queue.offer(edge.to);
                    }
                }
            }
        }
        return true;
    }

    // Dijktra's Algorithm
    // O(v+elog(v))
    public int findShortestPath(int src, int dest) {
        var distance = new int[graph.size()]; // Tracks minimum distance from src to all nodes
        for (var i = 0; i < distance.length; i++) {
            if (i != src) {
                distance[i] = Integer.MAX_VALUE;
            }
        }
        var srcNode = graph.get(src);
        var visited = new HashSet<Integer>();
        var minHeap = new PriorityQueue<NodeEntry>(Comparator.comparingInt(x -> x.weight));
        minHeap.add(new NodeEntry(srcNode, 0));
        while (!minHeap.isEmpty()) {
            var pop = minHeap.poll();

            if (visited.contains(pop.node.value)) {
                continue;
            }
            if (pop.node.value == dest) {
                System.out.println(Arrays.toString(distance));
                return pop.weight;
            }
            visited.add(pop.node.value);
            for (var edge : pop.node.edges) {
                if ((distance[pop.node.value] + edge.weight) < distance[edge.to.value]) {
                    distance[edge.to.value] = distance[pop.node.value] + edge.weight;
                    minHeap.offer(new NodeEntry(edge.to, pop.weight + edge.weight));
                }
            }
        }
        return -1;
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
