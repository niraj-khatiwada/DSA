import java.util.*;

import Backtracking.GridWays;

class Main {

    public static void main(String[] args) {
        var backtracking = new GridWays();
        System.out.println(backtracking.findNumberOfWays(3, 3));
        System.out.println(backtracking.findNumberOfWaysUsingMath(3, 3));
    }

}
