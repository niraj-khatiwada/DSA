import java.util.*;

import Greedy.FractionalKnapsack;

class Main {

    public static void main(String[] args) {
        var greedy = new FractionalKnapsack();
        System.out.println(greedy.maxProfit(
                new int[][] { { 120, 30 }, { 100, 20 }, { 62, 10 } },
                50));
        System.out.println((double) 10 / 3);

    }
}
