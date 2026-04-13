import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                new int[] { 1, 2, 3 },
                new int[] { 4, 5, 6 },
                new int[] { 7, 8, 9 }
        };
        List<Integer> result = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        // move right
        int row = 0;
        for (int col = 0; col < n; col++) {
            result.add(matrix[row][col]);
        }
        row += 1;
        // move down
        int col = n - 1;
        for (; row < m; row++) {
            result.add(matrix[row][col]);
        }
        col -= 1;

        System.out.println(result);
    }
}
