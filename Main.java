import Graphs.UndirectedGraph;

class Main {

    public static void main(String[] args) {
        var graph = new UndirectedGraph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");

        graph.addEdge("A", "B", 3);
        graph.addEdge("A", "C", 1);
        graph.addEdge("B", "C", 2);
        graph.addEdge("B", "D", 4);
        graph.addEdge("B", "E", 5);
        graph.addEdge("C", "D", 5);
        graph.addEdge("D", "E", 1);

        graph.minimumSpanningTree("A");
    }

}
