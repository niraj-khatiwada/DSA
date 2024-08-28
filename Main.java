import java.util.*;

import Greedy.IndianCoins;

class Main {

    public static void main(String[] args) {
        var greedy = new IndianCoins();
        System.out.println(greedy.minNumOfCoins(new int[] { 1, 2, 5, 10, 20, 50, 100, 500, 2000 }, 9832));
    }

}
