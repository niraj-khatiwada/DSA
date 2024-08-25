package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumNumberOfEvents {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(x -> x[0]));
        var heap = new PriorityQueue<Integer>();
        var d = 0;
        var i = 0;
        var c = 0;
        while (!heap.isEmpty() || i < events.length) {
            if (heap.isEmpty()) {
                d = events[i][0];
            }
            while (i < events.length && events[i][0] <= d) {
                heap.offer(events[i][1]);
                i++;
            }
            heap.poll();
            d++;
            c++;
            while (!heap.isEmpty() && heap.peek() < d) {
                heap.poll();
            }
        }
        return c;
    }
}
