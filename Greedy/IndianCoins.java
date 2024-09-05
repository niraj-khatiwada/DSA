package Greedy;

import java.util.ArrayList;

public class IndianCoins {
    private static int[] coins = new int[] { 1, 2, 5, 10, 20, 50, 100, 1000, };

    // O(numOfCoins)
    public void firstCoinsCombinations(int numOfCoins, int sum) {
        if (((double) sum / numOfCoins) > 1000.00) {
            System.out.println("Not possible");
            return;
        }

        var lastCoin = coins[coins.length - 1];
        var rs = new ArrayList<Integer>();
        while (numOfCoins > 0 && (sum / numOfCoins) <= lastCoin) {
            for (var i = coins.length - 1; i >= 0; i--) {
                var coin = coins[i];
                int maxCoin = sum / numOfCoins;
                if (coin <= maxCoin) {
                    rs.add(coin);
                    sum -= coin;
                    numOfCoins--;
                    break;
                }
            }
            if (sum == 0 && numOfCoins == 0) {
                System.out.println(rs);
                return;
            }
        }
        System.out.println("Not possible");
    }
}
