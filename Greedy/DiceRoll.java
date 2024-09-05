package Greedy;

import java.util.*;

public class DiceRoll {

    // O(numberOfRolls)
    /**
     * This is a greedy approach.
     * The idea is we divide the remaining sum with the remaining number of rolls.
     * We keep choosing that dice roll until sum becomes 0 and num of rolls also
     * become 0.
     * This way it is guaranteed that there'll be a combination if the sum is within
     * the range 1 - (6 * numOfRolls)
     */
    public void firstDiceCombination(int numOfRolls, int sum) {
        if (sum < numOfRolls || ((double) sum / numOfRolls) > 6.0) {
            System.out.println("Not possible");
            return;
        }

        var rs = new ArrayList<Integer>();

        while (numOfRolls > 0 && (sum / numOfRolls) <= 6) {
            for (var i = 6; i >= 1; i--) {
                if (i <= (sum / numOfRolls)) {
                    rs.add(i);
                    sum -= i;
                    numOfRolls--;
                    break;
                }
            }
            if (sum == 0 && numOfRolls == 0) {
                System.out.println(rs);
                return;
            }
        }
        System.out.println("Not possible");

    }

    // O(2^6)
    /**
     * You're given n number of attempts to roll a dice.
     * You're given a target sum t that you need to make from the dice occurrence
     * from that n attempts.
     * Return possible combinations
     * NOTE: If you've to return all possible combinations, you must perform all the
     * recursions
     **/
    public void diceCombinations(int numOfRolls, int sum) {
        this._diceCombinations(numOfRolls, numOfRolls, sum, new ArrayList<Integer>());
    }

    private void _diceCombinations(int n, int maxN, int sum, List<Integer> comb) {
        if (sum < 0 || n < 0 || comb.size() > maxN) {
            return;
        }

        if (sum == 0 && n == 0 && comb.size() == maxN) {
            System.out.println(comb);
            return;
        }

        for (var j = 1; j <= 6; j++) {
            var copy = new ArrayList<>(comb);
            copy.add(j);
            this._diceCombinations(n - 1, maxN, sum - j, copy);
            this._diceCombinations(n - 1, maxN, sum, new ArrayList<>(comb));
        }
    }

}