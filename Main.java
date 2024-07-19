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
        graph.addEdge("B", "C", 4);
        graph.addEdge("C", "D", 2);
        graph.addEdge("D", "E", 5);
        graph.addEdge("E", "C", 5);

        System.out.println(graph.hasCycle());

    }

}
