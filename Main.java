import java.util.*;

import Graph.UndirectedGraph;

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
        graph.addEdge("B", "E", 1);
        graph.addEdge("B", "D", 6);
        graph.addEdge("C", "D", 1);
        graph.addEdge("D", "E", 5);

        var path = graph.shortestPath("A", "E");
        System.out.println((int) path[0]);
        System.out.println((String) path[1]);
    }

}
