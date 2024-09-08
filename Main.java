import java.util.*;

import Graph.UndirectedGraph;

class Main {

    public static void main(String[] args) {
        var graph = new UndirectedGraph();
        graph.addNode(0);
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);
        graph.addNode(5);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 7);
        graph.addEdge(2, 4, 3);
        graph.addEdge(4, 3, 2);
        graph.addEdge(3, 5, 1);
        graph.addEdge(4, 5, 5);

        System.out.println(graph.findShortestPath(1, 5));
    }

}
