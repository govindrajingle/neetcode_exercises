
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosedPointsToOrigin {
    public static void main(String[] args) {
        int[][] points = { new int[] { 3, 3 }, new int[] { 5, -1 }, new int[] { -2, 4 } };
        int k = 2;
        int[][] result = new KClosedPointsToOrigin().kClosest(points, k);
        print2dArray(result);
    }

    public int[][] kClosest(int[][] points, int k) {

        Comparator<int[]> comparator = (a, b) -> {
            return (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]);
        };

        // Min heap based on distance from origin
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(comparator);

        // Add all points into heap
        for (int[] point : points) {
            minHeap.offer(point);
        }

        // Extract k closest
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }

        return result;
    }

    public static void print2dArray(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print("[" + grid[i][j] + "]");
            }
            System.out.println();
        }
    }
}
