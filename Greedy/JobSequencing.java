package Greedy;

import java.util.*;

public class JobSequencing {
    // TC: O(n^2)
    // SC: O(n)
    // jobs = [deadline, profit][]
    public int maximumProfit(int[][] jobs) {
        // SC: O(n*3) ~ O(n)
        var matrix = new int[jobs.length][3];
        var maxDeadline = Integer.MIN_VALUE;
        for (var i = 0; i < matrix.length; i++) {
            matrix[i][0] = i;
            matrix[i][1] = jobs[i][0]; // deadline
            matrix[i][2] = jobs[i][1]; // profit
            maxDeadline = Math.max(maxDeadline, jobs[i][0]);
        }
        // TC: O(nlog(n))
        Arrays.sort(matrix, (a, b) -> b[2] - a[2]);
        print(matrix);
        // SC: O(n)
        var slots = new int[maxDeadline];
        Arrays.fill(slots, -1);
        var profit = 0;
        // O(n^2)
        for (var i = 0; i < matrix.length; i++) {
            for (var j = (matrix[i][1] - 1); j >= 0; j--) {
                if (slots[j] == -1) {
                    slots[j] = matrix[i][0];
                    profit += matrix[i][2];
                    break;
                }
            }
        }
        System.out.println("------Sequence-----");
        for (var i = 0; i < slots.length; i++) {
            if (slots[i] != -1) {
                System.out.print(slots[i] + " ");
            }
        }
        System.out.println("\n-------");
        return profit;
    }

    public void print(int[][] grid) {
        for (var i = 0; i < grid.length; i++) {
            for (var j = 0; j < grid[0].length; j++) {
                System.out.printf("%5s", grid[i][j]);
            }
            System.out.println();
        }
    }

}
