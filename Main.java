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
        graph.addNode(6);
        graph.addEdge(0, 1, 7); // A -> B
        graph.addEdge(0, 3, 5); // A -> D
        graph.addEdge(1, 2, 8); // B -> C
        graph.addEdge(1, 4, 7); // B -> E
        graph.addEdge(1, 3, 9); // B -> D
        graph.addEdge(2, 4, 5); // C -> E
        graph.addEdge(3, 5, 6); // D -> F
        graph.addEdge(3, 4, 15);// D -> E
        graph.addEdge(4, 5, 8); // E -> F
        graph.addEdge(4, 6, 9); // E -> G
        graph.addEdge(5, 6, 11); // F -> G

        System.out.println(graph.minimumSpanningTree());
    }

}
