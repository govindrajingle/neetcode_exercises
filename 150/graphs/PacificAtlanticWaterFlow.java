import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {

    static int m, n;
    static List<int[]> directions = Arrays.asList(
            new int[] { 0, -1 },
            new int[] { 0, 1 },
            new int[] { -1, 0 },
            new int[] { 1, 0 });

    public static void main(String[] args) {

        int[][] heights = {
                { 4, 2 },
                { 3, 1 }
        };

        List<List<Integer>> result = waterFlow(heights);
        System.out.println(result);
    }

    static List<List<Integer>> waterFlow(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        m = heights.length;
        n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        // Fill the pacific by left and top
        for (int i = 0; i < m; i++)
            dfs(heights, i, 0, pacific);
        for (int j = 0; j < n; j++)
            dfs(heights, 0, j, pacific);
        // Fill the atlantic by right and bottom
        for (int i = 0; i < m; i++)
            dfs(heights, i, n - 1, atlantic);
        for (int j = 0; j < n; j++)
            dfs(heights, m - 1, j, atlantic);
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (pacific[i][j] && atlantic[i][j])
                    result.add(Arrays.asList(i, j));
        return result;
    }

    private static void dfs(int[][] heights, int row, int col, boolean[][] visited) {
        // Without thinking mark this as visited (true)
        visited[row][col] = true;
        // You have to move left, right, up and down (0,-1) (0,1) (-1,0) and (1,0)
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            // Handle the boundry with equality
            if (newRow < 0 || newCol < 0 || newRow >= m || newCol >= n)
                continue;
            // Check if that cell is already visited
            if (visited[newRow][newCol])
                continue;
            // Main logic : As we move from outward to inward the height of newly formatted
            // row and column is to be greater than previous one
            if (heights[newRow][newCol] >= heights[row][col])
                dfs(heights, newRow, newCol, visited);
        }
    }

}