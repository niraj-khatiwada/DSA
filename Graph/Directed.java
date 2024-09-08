package Graph;

import java.util.*;

public class Directed {

    private class Edge {
        public Node to;

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
            throw new IllegalArgumentException("from node does not exit");
        }
        var toNode = graph.get(to);
        if (toNode == null) {
            throw new IllegalArgumentException("to node does not exit");
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
            var res = _hasCycle(edge.to, node, visiting, path);
            if ((boolean) res[0]) {
                return res;

            }
        }
        visiting.remove(node.value); // Need to backtrack for directed if circular was not found.
        path.remove(node.value);
        return new Object[] { false, null, null };
    }

    // O(v+e)
    // SC: O(v) for extra stack and array list
    public List<Integer> topologicalSort() {
        var visited = new HashSet<Integer>();
        var stack = new Stack<Integer>();
        for (var entry : graph.entrySet()) {
            this._topologicalSort(entry.getValue(), stack, visited);
        }
        var sorted = new ArrayList<Integer>();
        while (!stack.isEmpty()) {
            sorted.add(stack.pop());
        }
        return sorted;
    }

    private void _topologicalSort(Node node, Stack<Integer> stack, Set<Integer> visited) {
        if (node == null || visited.contains(node.value)) {
            return;
        }
        for (var edge : node.edges) {
            _topologicalSort(edge.to, stack, visited);
        }
        visited.add(node.value);
        stack.push(node.value);
    }

    // Kahn's algorithm for topological sorting
    // O in degree vertices must be first and 0 out degree vertices must be last in
    // the sorted list
    // Gist of this algorithm is, if a vertex does not have any other dependency,
    // add it to queue.
    public List<Integer> kahnsAlgorithm() {
        var inDegree = new HashMap<Integer, Integer>();
        for (var entry : graph.entrySet()) {
            inDegree.put(entry.getKey(), 0);

        }
        for (var entry : graph.entrySet()) {
            var edges = entry.getValue().edges;
            for (var edge : edges) {
                inDegree.put(edge.to.value, inDegree.get(edge.to.value) + 1);
            }
        }
        var queue = new ArrayDeque<Integer>();
        for (var entry : inDegree.entrySet()) {
            // If it has in degree 0, that means it does not have any other dependency to
            // wait for. It can perform it's task.
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }
        var sorted = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            var pop = queue.poll();
            sorted.add(pop);
            var node = graph.get(pop);
            for (var edge : node.edges) {
                inDegree.put(edge.to.value, inDegree.get(edge.to.value) - 1);
                // If it has in degree 0, that means it does not have any other dependency to
                // wait for. It can perform it's task.
                if (inDegree.get(edge.to.value) == 0) {
                    queue.add(edge.to.value);
                }
            }
        }
        return sorted;
    }

    // O(v^v)
    public void allPathsFromSrcToDest(int src, int dest) {
        var srcNode = graph.get(src);
        var path = new ArrayList<Integer>();
        this._allPathsFromSrcToDest(srcNode, dest, path);
    }

    private void _allPathsFromSrcToDest(Node node, int target, List<Integer> path) {
        if (node == null) {
            return;
        }
        if (node.value == target) {
            var copy = new ArrayList<Integer>(path);
            copy.add(node.value);
            System.out.println(copy);
            return;
        }
        path.add(node.value);
        for (var edge : node.edges) {
            _allPathsFromSrcToDest(edge.to, target, path);
        }
        path.remove(Integer.valueOf(node.value));
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
