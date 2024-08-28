import java.util.*;

import Greedy.ChocolaProblem;

class Main {

    public static void main(String[] args) {
        var greedy = new ChocolaProblem();
        System.out.println(greedy.minimalCost(new int[] { 4, 1, 2 }, new int[] { 2, 1, 3, 1, 4 }));
    }

}
