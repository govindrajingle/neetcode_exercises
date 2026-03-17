import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RottingOranges {
    public static void main(String[] args) {
        int[][] grid = new int[3][3];
        grid[0] = new int[] { 2, 1, 1 };
        grid[1] = new int[] { 1, 1, 0 };
        grid[2] = new int[] { 0, 1, 1 };
        printArray(grid);
        int time = orangesRotting(grid);
        printArray(grid);
        System.out.println("Time is: " + time);
    }

    static void printArray(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("[" + grid[i][j] + "]");
            }
            System.out.println();
        }
        System.out.println();
    }

    static List<List<Integer>> directions = Arrays.asList(
            List.of(0, -1),
            List.of(0, 1),
            List.of(-1, 0),
            List.of(1, 0));

    static int time = 0;

    static public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        int fresh = 0;
        // Find the rotten orange add it to queue and maintain the count of fresh
        // oranges also
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    fresh += 1;
                }
            }
        }
        // If no fresh oranges are present
        if (fresh == 0)
            return time;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rot = false;
            // To make exactly only neighbours to rot for ont instance or minute
            for (int k = 0; k < size; k++) {
                // Below block makes all fresh oranges to rot in single minute
                int[] rotten = queue.poll();
                // get the directions to be moved
                for (List<Integer> direction : directions) {
                    int row = rotten[0] + direction.get(0);
                    int col = rotten[1] + direction.get(1);
                    if (row < 0 || col < 0 || row >= m || col >= n)
                        continue;
                    // Threre is chance that all of the neighbours are empty or all rotten, so use
                    // flag to mark that you have found the rotten
                    if (grid[row][col] == 1) {
                        grid[row][col] = 2;
                        queue.add(new int[] { row, col });
                        fresh -= 1;
                        rot = true;

                    }
                }
            }
            if (rot)
                time += 1;

        }
        return time;
    }

}
