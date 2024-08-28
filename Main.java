import java.util.*;

import Greedy.ChocolaProblem;

class Main {

    public static void main(String[] args) {
        var greedy = new ChocolaProblem();
        System.out.println(greedy.minimalCost(new int[] { 4, 1, 2 }, new int[] { 2, 1, 3, 1, 4 }));
        System.out.println(_search(new int[][] { { 1, 3 }, { 2, 4 }, { 3, 5 }, { 3, 6 } }, 0));
    }

    private static int _search(int[][] matrix, int i) {
        var l = i + 1;
        var r = matrix.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (matrix[m][0] >= matrix[i][1]) {
                r = m;
            } else {
                l = m + 1;
            }
            if (l == r) {
                return r;
            }
        }
        return -1;
    }

}
