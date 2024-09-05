package Greedy;

import java.util.ArrayList;

public class IndianCoins {
    private static int[] coins = new int[] { 1, 2, 5, 10, 20, 50, 100, 1000, };

    // O(numOfCoins)
    public void firstCoinsCombinations(int numOfCoins, int sum) {
        var maxCoin = coins[coins.length - 1];
        if (numOfCoins > sum || (numOfCoins * maxCoin) < sum) {
            System.out.println("Not possible");
            return;
        }

        var rs = new ArrayList<Integer>();
        while (numOfCoins > 0) {
            for (var i = coins.length - 1; i >= 0; i--) {
                var coin = coins[i];
                if ((sum - coin) >= (numOfCoins - 1)) {
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
