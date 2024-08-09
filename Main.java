import java.util.*;

import Graph.Graph;

class Main {

    public static void main(String[] args) {
        var graph = new Graph();
        graph.addNode("Dwight");
        graph.addNode("Michael");
        graph.addNode("Pam");
        graph.addNode("Jim");
        graph.addNode("Andy");
        graph.addNode("Erin");

        graph.addEdge("Michael", "Dwight");
        graph.addEdge("Jim", "Pam");
        graph.addEdge("Michael", "Jim");
        graph.addEdge("Dwight", "Pam");
        graph.addEdge("Pam", "Jim");

        System.out.println(graph.detectCycle());

    }

}
