import java.util.*;

import DP.KnapSack01;

class Main {

    public static void main(String[] args) {
        var backtracking = new KnapSack01();
        System.out.println(
                backtracking.knapSackTabulation(new int[] { 15, 14, 10, 45, 30 },
                        new int[] { 2, 5, 1, 3, 4 }, 7));

    }

}
