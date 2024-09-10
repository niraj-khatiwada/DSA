package Graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class ConnectingCitiesWithMinimumCost {

    // O(v^2 * log(v))
    // Here 0 means there's no path between cities
    // { { 0, 1, 2, 3, 4 },
    // { 1, 0, 5, 0, 7 },
    // { 2, 5, 0, 6, 0 },
    // { 3, 0, 6, 0, 0 },
    // { 4, 7, 0, 0, 0 } }
    public int minimumCost(int[][] cities) {
        var cost = 0;
        var visited = new HashSet<Integer>();
        var queue = new PriorityQueue<int[]>(Comparator.comparingInt(x -> x[1]));
        queue.offer(new int[] { 0, 0 });
        while (visited.size() != cities.length) {
            var current = queue.poll();
            var i = current[0];
            if (visited.contains(i)) {
                continue;
            }
            visited.add(i);
            cost += current[1];
            for (var j = 0; j < cities.length; j++) {
                if (i != j && !visited.contains(j) && cities[i][j] != 0) {
                    queue.offer(new int[] { j, cities[i][j] });
                }
            }
        }
        return cost;
    }

}
