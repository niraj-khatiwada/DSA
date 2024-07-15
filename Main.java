import Graphs.Graph;

class Main {
    public static void main(String[] args) {
        var graph = new Graph();
        graph.addNode("Z");
        graph.addNode("P");
        graph.addNode("X");
        graph.addNode("B");
        graph.addNode("A");

        graph.addEdge("X", "A");
        graph.addEdge("A", "P");
        graph.addEdge("B", "P");
        graph.addEdge("X", "B");
        graph.addEdge("Z", "X");

        graph.topologicalSorting();
    }

}
