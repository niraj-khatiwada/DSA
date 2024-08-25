import java.util.*;

import Greedy.MaximumNumberOfEvents;

class Main {

    public static void main(String[] args) {
        var greedy = new MaximumNumberOfEvents();
        System.out.println(greedy.maxEvents(new int[][] { { 1, 4 }, { 4, 4 }, { 2, 2 }, { 3, 4 }, { 1, 1 } }));

    }

}
