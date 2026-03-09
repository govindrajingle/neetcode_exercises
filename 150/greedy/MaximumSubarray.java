// 123. Find the maximum maxSum of subarray
public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        // Output = 6
        // int ans = maxSubArrayKadane(nums);
        int ans = maxSubArray(nums, 0, nums.length - 1);
        System.out.println("Maximum maxSum of sub array is " + ans);
    }

    // Greedy -> make the best local choice every step
    public static int maxSubArrayKadane(int[] nums) {
        // Create two variables currentSum and maxSum starting from first element,
        // update currentSum only when it is greater that nums[i] after sum with it
        int n = nums.length;
        if (n == 0)
            return -1;
        int maxSum = nums[0];
        int currentSum = nums[0];
        for (int i = 1; i < n; i++) {
            currentSum = Math.max(currentSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static int maxSubArray(int[] nums, int left, int right) {
        // Don't user while or if loop. For divide and conquer we don't need that
        if (left == right)
            return nums[left];
        int mid = left + (right - left) / 2;
        int leftSum = maxSubArray(nums, left, mid);
        int rightSum = maxSubArray(nums, mid + 1, right);
        int maxSum = crossSum(nums, left, mid, right);
        return Math.max(Math.max(leftSum, rightSum), maxSum);
    }

    public static int crossSum(int[] nums, int left, int mid, int right) {
        int leftSum = Integer.MIN_VALUE;
        int currentLeftSum = 0;
        // To include the left half start by mid to include it
        for (int i = mid; i >= left; i--) {
            currentLeftSum += nums[i];
            leftSum = Math.max(leftSum, currentLeftSum);
        }
        int rightSum = Integer.MIN_VALUE;
        int currentRightSum = 0;
        for (int i = mid + 1; i <= right; i++) {
            currentRightSum += nums[i];
            rightSum = Math.max(rightSum, currentRightSum);
        }
        return leftSum + rightSum;
    }
}
