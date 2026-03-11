
public class SingleNumber {
    // In given array the duplicate elements are adjacent and appear even times and
    // unique element appear only one time
    public static void main(String[] args) {
        int[] nums = { 2, 2, 4, 4, 7 };
        int result = singleElement(nums);
        System.out.println("Unique number is: " + result);
    }

    static int singleElement(int[] nums) {
        int result = 0;
        // Use XOR (Exclusive OR) a ^ 0 = a and a ^ a = 0
        for (int n : nums) {
            result ^= n;
        }
        return result;
    }
}
