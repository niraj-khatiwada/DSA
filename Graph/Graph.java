package Graph;

import java.util.*;

public class Graph {

    public HashMap<String, List<String>> graph;

    public Graph() {
        this.graph = new HashMap<>();
    }

    // O(1)
    public void addNode(String value) {
        this.graph.put(value, new LinkedList<>());
    }

    // O(v^2)
    public void removeNode(String value) {
        this.graph.remove(value);
        for (var entry : this.graph.entrySet()) {
            if (!entry.getKey().equals(value)) {
                entry.getValue().remove(value);
            }
        }
    }

    // O(k)
    public void addEdge(String from, String to) {
        if (!from.equals(to)) {
            var fromNode = this.graph.get(from);
            // O(k)
            if (!fromNode.contains(to)) {
                fromNode.add(to);
            }
        }

    }

    // O(k)
    public void removeEdge(String from, String to) {
        var fromNode = this.graph.get(from);
        // O(k)
        fromNode.remove(to);
    }

    // O(v)
    public void dfs(String value) {
        var visited = new HashSet<String>();
        this._dfs(value, visited);
    }

    void _dfs(String value, Set<String> visited) {
        if (visited.contains(value)) {
            return;
        }
        System.out.println(value);
        visited.add(value);
        var list = this.graph.get(value);
        if (list == null) {
            return;
        }
        for (var i : list) {
            _dfs(i, visited);
        }
    }

    // O(v)
    public void bfs(String value) {
        var visited = new HashSet<String>();
        var queue = new ArrayDeque<String>();
        queue.add(value);
        var level = 0;
        while (!queue.isEmpty()) {
            System.out.println(level);
            var size = queue.size();
            for (var j = 0; j < size; j++) {
                var pop = queue.poll();
                System.out.println(pop);
                visited.add(pop);
                for (var i : this.graph.get(pop)) {
                    if (!visited.contains(i)) {
                        queue.add(i);
                    }
                }
            }
            level++;
        }
    }

    public void topologicalSort() {
        var visited = new HashSet<String>();
        var stack = new Stack<String>();
        for (var entry : this.graph.entrySet()) {
            this._topologicalSort(entry.getKey(), visited, stack);
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    // O(v)
    // To make topological sort work, we need to properly add edges like shown in
    // topological-sort.png
    private void _topologicalSort(String value, HashSet<String> visited, Stack<String> stack) {
        if (visited.contains(value)) {
            return;
        }
        visited.add(value);
        for (var e : this.graph.get(value)) {
            _topologicalSort(e, visited, stack);
        }
        stack.add(value);
    }

    // O(v)
    public boolean detectCycle() {
        var visited = new HashSet<String>();
        var rs = new boolean[] { false };
        for (var entry : this.graph.entrySet()) {
            var visiting = new HashSet<String>();
            this._detectCycle(entry.getKey(), visited, visiting, rs);
        }
        return rs[0];
    }

    public void _detectCycle(String value, HashSet<String> visited, HashSet<String> visiting, boolean[] rs) {
        if (visited.contains(value)) {
            return;
        }
        if (visiting.contains(value)) {
            rs[0] = true;
            return;
        }
        visiting.add(value);
        for (var e : this.graph.get(value)) {
            _detectCycle(e, visited, visiting, rs);
        }
        visited.add(value);

    }

    // O(v)
    public void print() {
        for (var entry : this.graph.entrySet()) {
            System.out.println(entry.getKey());
            for (var i : entry.getValue()) {
                System.out.printf(" > %s\n", i);
            }
        }
    }

}

// Topological Sorting
// var graph = new Graph();
// graph.addNode("X");
// graph.addNode("A");
// graph.addNode("B");
// graph.addNode("P");

// graph.addEdge("X", "A");
// graph.addEdge("X", "B");
// graph.addEdge("A", "P");
// graph.addEdge("B", "P");

// graph.topologicalSort();