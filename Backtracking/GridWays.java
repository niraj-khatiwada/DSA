package Backtracking;

public class GridWays {
    // Using Math
    // O(n+m)
    public int findNumberOfWaysUsingMath(int n, int m) {
        return (_factorial(n + m - 2) / ((_factorial(n - 1) * _factorial(m - 1))));
    }

    // O(2^(n+m))
    public int findNumberOfWays(int n, int m) {
        var grid = new int[n][m];
        return this._findNumberOfWays(grid, 0, 0);
    }

    private int _findNumberOfWays(int[][] grid, int x, int y) {
        if (x >= grid.length || y >= grid[0].length) {
            return 0;
        }
        if (x == (grid.length - 1) && y == (grid[0].length - 1)) {
            return 1;
        }
        return _findNumberOfWays(grid, x, y + 1) + _findNumberOfWays(grid, x + 1, y);
    }

    private int _factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * _factorial(n - 1);
    }
}
