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
        graph.addEdge("A", "C", 4);
        graph.addEdge("A", "D", 2);
        graph.addEdge("B", "D", 6);
        graph.addEdge("B", "E", 1);
        graph.addEdge("C", "D", 1);
        graph.addEdge("D", "E", 5);

        System.out.println(graph.findShortestPath("A", "C")); // A -> D -> C
        System.out.println(graph.findShortestPath("A", "E")); // A -> B -> E

    }

}
