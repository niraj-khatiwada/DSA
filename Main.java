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
        graph.addEdge(3, 5);
        graph.addEdge(5, 4);

        graph.postOrderDFSUsingStack(1);
    }

}
