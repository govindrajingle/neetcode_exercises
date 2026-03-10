import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 26;
        int[] ans = twoSum(nums, target);
        System.out.println(Arrays.toString(ans));
    }

    static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (hmap.containsKey(diff)) {
                return new int[] { hmap.get(diff), i };
            } else {
                // Store the array elements with their indices, not difference
                hmap.put(nums[i], i);
            }
        }
        return null;
    }
}
