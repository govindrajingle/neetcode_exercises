//202
public class HapppyNumber {
    // Example 1:
    // Input: n = 19
    // Output: true
    // Explanation:
    // 1^2 + 9^2 = 82
    // 8^2 + 2^2 = 68
    // 6^2 + 8^2 = 100
    // 1^2 + 0^2 + 0^2 = 1

    // Example 2:
    // Input: n = 2
    // Output: false
    public static void main(String[] args) {
        int n = 19;
        int slow = squaredNum(n);
        int fast = squaredNum(squaredNum(n));
        while (slow != fast) {
            slow = squaredNum(slow);
            fast = squaredNum(squaredNum(fast));
        }
        System.out.println(slow == 1);
    }

    public static int squaredNum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += Math.pow(num % 10, 2);
            num /= 10;
        }
        return sum;
    }
}
