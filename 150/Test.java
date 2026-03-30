import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        int start = 0, end = 0;
        String s = "SBSVVRAT";
        List<String> wordList = List.of("S", "BSVV", "RAT");
        int[] nums = { 23, 12, 53, 1, 56, 93, 100 };
        System.out.println(findKthMaximum(nums, 3));
        iterateHashMap();
        // System.out.println(solve(start, end, s, wordList));
    }

    public static void iterateHashMap() {
        Map<Integer, String> map = new HashMap<>();
        map.putIfAbsent(1, "something");
        map.putIfAbsent(2, "is");
        for (Map.Entry<Integer, String> data : map.entrySet()) {
            System.out.println(data.getKey() + " : " + data.getValue());
        }
    }

    public static int findKthMaximum(int[] arr, int k) {
        int num = arr[0];
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int n : arr) {
            maxHeap.add(n);
        }
        while (k != 0) {
            num = maxHeap.poll();
            k--;
        }
        return num;
    }

    public static boolean solve(int start, int end, String s, List<String> wordList) {
        Set<String> wd = new HashSet<>();
        wd.addAll(wordList);
        // Find the end is reached to total string length
        if (end == s.length() - 1) {
            String word = s.substring(start, end + 1);
            if (wd.contains(word)) {
                return true;
            }
            return false;
        }
        // Check the substring is present or not
        String word = s.substring(start, end + 1);
        if (wd.contains(word)) {
            boolean result = solve(end + 1, end + 1, s, wordList);
            if (result)
                return true;
        }

        // Recursive case
        return solve(start, end + 1, s, wordList);
    }
}
