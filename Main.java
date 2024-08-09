import java.util.*;

import Graph.Graph;

class Main {

    public static void main(String[] args) {
        var graph = new Graph();
        graph.addNode("Dwight");
        graph.addNode("Michael");
        graph.addNode("Pam");
        graph.addNode("Jim");

        graph.addEdge("Michael", "Dwight");
        graph.addEdge("Michael", "Jim");
        graph.addEdge("Jim", "Pam");
        // graph.addEdge("Dwight", "Pam");
        graph.addEdge("Pam", "Jim");

        System.out.println(graph.detectCycle());

    }

}
