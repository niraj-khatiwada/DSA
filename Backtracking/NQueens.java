package Backtracking;

public class NQueens {
    public void findNQueens(int n) {
        var grid = new char[n][n];
        var rs = new int[] { 0 };

        for (var i = 0; i < n; i++) {
            for (var j = 0; j < n; j++) {
                grid[i][j] = '.';
            }
        }
        this._findNQueens(grid, 0, rs);

        System.out.printf("Found %s possibilities.\n", rs[0]);

    }

    private void _findNQueens(char[][] grid, int i, int[] rs) {
        if (i >= grid.length) {
            this.printGrid(grid);
            rs[0]++;
            return;
        }

        for (var j = 0; j < grid.length; j++) {
            if (this._isSafeToPlace(grid, i, j)) {
                grid[i][j] = 'Q';
                _findNQueens(grid, i + 1, rs);
                grid[i][j] = '.';
            }
        }
    }

    private boolean _isSafeToPlace(char[][] grid, int x, int y) {
        // Up
        for (var i = (x - 1); i >= 0; i--) {
            if (grid[i][y] == 'Q') {
                return false;
            }
        }

        // Diagonal Up Left
        for (int i = (x - 1), j = (y - 1); i >= 0 && j >= 0; i--, j--) {
            if (grid[i][j] == 'Q') {
                return false;
            }
        }

        // Diagonal Up Right
        for (int i = (x - 1), j = (y + 1); i >= 0 && j < grid.length; i--, j++) {
            if (grid[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private void printGrid(char[][] grid) {
        System.out.println("-----------");
        for (var i = 0; i < grid.length; i++) {
            for (var j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
