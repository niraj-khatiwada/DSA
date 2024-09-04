import java.util.*;

import Graph.DirectedGraph;

class Main {

    public static void main(String[] args) {
        var graph = new DirectedGraph();
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);
        graph.addNode(5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        // graph.preOrderDfs(1);
        System.out.println(graph.pathExists(1, 5));
    }

}
