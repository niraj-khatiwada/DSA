import Graphs.Graph;

class Main {
    public static void main(String[] args) {
        var graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        graph.addEdge("A", "B");
        graph.addEdge("B", "C");
        // graph.addEdge("C", "A");
        graph.addEdge("D", "A");

        System.out.println(graph.hasCycle());
    }

}
