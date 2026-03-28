import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifference {
    public static void main(String[] args) {
        // Output: 2
        int[] nums = { 1, 0, 0, 2, 0, 1 };
        System.out.println(minAbsoluteDifference(nums));
    }

    public static int minAbsoluteDifference(int[] nums) {
        List<Integer> indices1 = new ArrayList<>();
        List<Integer> indices2 = new ArrayList<>();
        int i = 0;
        for (int n : nums) {
            if (n == 1) {
                indices1.add(i);
            } else if (n == 2) {
                indices2.add(i);
            }
            i += 1;
        }
        if (indices1.isEmpty() || indices2.isEmpty())
            return -1;
        int p1 = 0, p2 = 0;
        int min = Integer.MAX_VALUE;

        while (p1 < indices1.size() && p2 < indices2.size()) {
            int idx1 = indices1.get(p1);
            int idx2 = indices2.get(p2);

            min = Math.min(min, Math.abs(idx1 - idx2));

            if (idx1 < idx2) {
                p1++;
            } else {
                p2++;
            }
        }

        return min;
    }
}
