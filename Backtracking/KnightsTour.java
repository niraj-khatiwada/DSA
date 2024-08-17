package Backtracking;

import java.util.*;

public class KnightsTour {
    public void knightsTour(int n) {
        var board = new int[n][n];
        for (var i = 0; i < n; i++) {
            for (var j = 0; j < n; j++) {
                board[i][j] = -1;
            }
        }
        this._knightsTour(board, 0, 0, 0);
    }

    private boolean _knightsTour(int[][] board, int x, int y, int c) {
        if (x < 0 || x >= board.length || y < 0 || y >= board.length ||
                board[x][y] != -1) {
            return false;
        }

        board[x][y] = c;

        if (c == (board.length * board.length - 1)) {
            print(board);
            return true;
        }

        // Be careful, this order matters. Other order combination might lead to
        // infinite loop.
        // Order is Bottom-Right -> Top-Right -> Top-Left -> Bottom-Left
        int[] dx = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int[] dy = { 1, 2, 2, 1, -1, -2, -2, -1 };

        for (int i = 0; i < 8; i++) {
            if (_knightsTour(board, x + dx[i], y + dy[i], c + 1)) {
                return true;
            }
        }

        board[x][y] = -1;

        return false;
    }

    public void print(int[][] board) {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board.length; y++)
                System.out.print(board[x][y] + " ");
            System.out.println();
        }
    }

    int N = 8;

    public boolean isSafe(int x, int y, int sol[][]) {
        return (x >= 0 && x < N && y >= 0 && y < N
                && sol[x][y] == -1);
    }

    public void printSolution(int sol[][]) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++)
                System.out.print(sol[x][y] + " ");
            System.out.println();
        }
    }

    public boolean solveKT() {
        int sol[][] = new int[8][8];
        for (int x = 0; x < N; x++)
            for (int y = 0; y < N; y++)
                sol[x][y] = -1;

        // As the Knight starts from cell(0,0)
        sol[0][0] = 0;
        if (!solveKTUtil(0, 0, 1, sol)) {
            System.out.println("Solution does not exist");
            return false;
        } else
            printSolution(sol);
        return true;
    }

    public boolean solveKTUtil(int x, int y, int movei, int sol[][]) {
        if (movei == N * N)
            return true;

        int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

        for (int k = 0; k < 8; k++) {
            int next_x = x + xMove[k];
            int next_y = y + yMove[k];
            if (isSafe(next_x, next_y, sol)) {
                sol[next_x][next_y] = movei;
                if (solveKTUtil(next_x, next_y, movei + 1,
                        sol))
                    return true;
                else
                    sol[next_x][next_y] = -1; // backtracking
            }
        }
        return false;
    }

    public void main(String args[]) {
        solveKT();
    }

}
