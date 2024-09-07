import java.util.*;

import Graph.Directed;

class Main {

    public static void main(String[] args) {
        var graph = new Directed();
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        // graph.addNode(4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 2);

        System.out.println(graph.topologicalSort());
    }

}
