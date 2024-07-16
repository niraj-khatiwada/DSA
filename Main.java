import Graphs.UndirectedGraph;

class Main {

    public static void main(String[] args) {
        var graph = new UndirectedGraph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        graph.addEdge("A", "B", 2);
        graph.addEdge("B", "C", 3);
        graph.addEdge("C", "D", 4);

        graph.print();

    }
}
