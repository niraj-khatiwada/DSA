package Backtracking;

import java.util.*;

public class RatInMaze {
    public void findPossiblePath(int[][] maze) {
        var visited = new TreeSet<int[]>((a, b) -> Arrays.compare(a, b));
        this._findPossiblePath(maze, 0, 0, visited, "");
    }

    private void _findPossiblePath(int[][] maze, int x, int y, TreeSet<int[]> visited, String path) {
        if (x < 0 || x >= maze.length || y < 0 || y >= maze[0].length || maze[x][y] == 0
                || visited.contains(new int[] { x, y })) {
            return;
        }

        if (x == (maze.length - 1) && y == (maze[0].length - 1)) {
            System.out.println(path.toString());
            return;
        }

        var coord = new int[] { x, y };
        visited.add(coord);

        _findPossiblePath(maze, x, y + 1, visited, path + "R");
        _findPossiblePath(maze, x + 1, y, visited, path + "D");
        _findPossiblePath(maze, x, y - 1, visited, path + "L");
        _findPossiblePath(maze, x - 1, y, visited, path + "U");

        // Backtrack
        visited.remove(coord);

    }

}
