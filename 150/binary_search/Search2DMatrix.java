
// Given matrix is sorted meaning the first cell value of row will be always greater than las cell value of previous row
public class Search2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = { { 1, 3, 6 }, { 7, 9, 20 }, { 24, 45, 66 } };
        int targetValue = 66;
        boolean ans = searchMatrix(matrix, targetValue);
        System.out.println("Element found in matrix " + ans);
    }

    public static boolean searchMatrix(int[][] matrix, int targetValue) {
        // Good to handle the empty matrix case
        if (matrix.length == 0)
            return false;
        // Lets perform binary search
        int m = matrix.length, n = matrix[0].length;
        int start = 0, end = m * n;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int row = mid / n;
            int col = mid % n;
            if (matrix[row][col] == targetValue)
                return true;
            else if (matrix[row][col] < targetValue) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
