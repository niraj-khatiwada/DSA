import Graphs.Graph;

class Main {
    public static void main(String[] args) {
        var graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");

        graph.addEdge("B", "C");
        graph.addEdge("B", "A");

        // graph.removeEdge("A", "B");
        // graph.removeEdge("A", "C");

        // graph.removeNode("A");
        // graph.removeNode("C");

        graph.print();
        System.out.println("-----------------");
        graph.depthFirstTraversal("C");
    }

}
