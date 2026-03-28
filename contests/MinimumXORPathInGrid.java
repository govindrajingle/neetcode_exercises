
import java.util.List;

public class MinimumXORPathInGrid {
    public static void main(String[] args) {

        // 6
        int[][] grid = { new int[] { 1, 2 }, new int[] { 3, 4 } };
        // 0
        // int[][] grid = { new int[] { 2, 7, 5 } };
        System.out.println(minCost(grid));

    }

    public static int minCost(int[][] grid) {
        return minXOR(grid, 0, 0, grid[0][0]);
    }

    public static int minXOR(int[][] grid, int i, int j, int current) {
        int rows = grid.length;
        int cols = grid[0].length;

        // check destination
        if (i == rows - 1 && j == cols - 1) {
            return current;
        }

        int min = Integer.MAX_VALUE;

        // move right
        if (j + 1 < cols) {
            min = Math.min(min, minXOR(grid, i, j + 1, current ^ grid[i][j + 1]));
        }

        // move down
        if (i + 1 < rows) {
            min = Math.min(min, minXOR(grid, i + 1, j, current ^ grid[i + 1][j]));
        }

        return min >= 0 ? min : -1;
    }
}
