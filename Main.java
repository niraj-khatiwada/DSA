import java.util.*;

import Greedy.JobSequencing;

class Main {

    public static void main(String[] args) {
        var greedy = new JobSequencing();
        System.out.println(greedy.maximumProfit(new int[][] { { 4, 100 }, { 1, 10 }, { 1, 40 }, { 1, 30 } }));
    }

}
