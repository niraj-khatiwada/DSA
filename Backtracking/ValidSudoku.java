package Backtracking;

import java.util.*;

public class ValidSudoku {
    // This is not backtracking approach but Leetcode approach.
    // You can do backtracking just like NQueens approach but it's going to be
    // fairly inefficient
    // O(n^2)
    public boolean validSudoku(int[][] grid) {
        var rowMap = new HashMap<Integer, Set<Integer>>();
        var columnMap = new HashMap<Integer, Set<Integer>>();
        var subgridMap = new HashMap<String, Set<Integer>>();

        for (var i = 0; i < grid.length; i++) {
            for (var j = 0; j < grid.length; j++) {
                if (grid[i][j] != 0) {
                    // Row
                    var rowSet = rowMap.get(i);
                    if (rowSet == null) {
                        rowSet = new HashSet<Integer>();
                    } else {
                        if (rowSet.contains(grid[i][j])) {
                            System.out.printf("%s \n", grid[i][j]);
                            return false;
                        }
                    }
                    rowSet.add(grid[i][j]);
                    rowMap.put(i, rowSet);

                    // Sub Grid
                    var key = String.format("%s|%s", i / 3, j / 3);
                    var subgridSet = subgridMap.get(key);
                    if (subgridSet == null) {
                        subgridSet = new HashSet<Integer>();
                    } else {
                        if (subgridSet.contains(grid[i][j])) {
                            System.out.printf("%s\n", grid[i][j]);
                            return false;
                        }
                    }
                    subgridSet.add(grid[i][j]);
                    subgridMap.put(key, subgridSet);
                }

                if (grid[j][i] != 0) {
                    // Column
                    var columnSet = columnMap.get(j);
                    if (columnSet == null) {
                        columnSet = new HashSet<Integer>();
                    } else {
                        if (columnSet.contains(grid[j][i])) {
                            System.out.printf("%s \n", grid[j][i]);
                            return false;
                        }
                    }
                    columnSet.add(grid[j][i]);
                    columnMap.put(j, columnSet);
                }

            }
        }

        return true;

    }

}