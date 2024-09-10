import java.util.*;

import Graph.ConnectingCitiesWithMinimumCost;

class Main {

    public static void main(String[] args) {
        var graph = new ConnectingCitiesWithMinimumCost();

        System.out.println(graph.minimumCost(new int[][] { { 0, 1, 2, 3, 4 },
                { 1, 0, 5, 0, 7 },
                { 2, 5, 0, 6, 0 },
                { 3, 0, 6, 0, 0 },
                { 4, 7, 0, 0, 0 } }));
    }

}
