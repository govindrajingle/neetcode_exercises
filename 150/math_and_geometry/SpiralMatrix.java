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
        int top = 0, left = 0;
        int bottom = matrix.length - 1, right = matrix[0].length - 1;
        while (top <= bottom && left <= right) {
            // move right
            for (int col = left; col <= right; col++)
                result.add(matrix[top][col]);
            top++;

            // move down
            if (top <= bottom) {
                for (int row = top; row <= bottom; row++)
                    result.add(matrix[row][right]);
                right--;
            }

            // move left
            if (left <= right && top <= bottom) {
                for (int col = right; col >= left; col--)
                    result.add(matrix[bottom][col]);
                bottom--;
            }

            // move up
            if (top <= bottom && left <= right) {
                for (int row = bottom; row >= top; row--)
                    result.add(matrix[row][left]);
                left++;
            }
        }
        System.out.println(result);
    }
}
