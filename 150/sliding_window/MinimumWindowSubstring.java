
// 76

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "abcdefab", t = "dea";
        String result = "";
        int[] arr = new int[256];
        for (char ch : t.toCharArray()) {
            arr[ch] += 1;
        }
        int left = 0, right = 0, minLength = Integer.MAX_VALUE, requiredLength = t.length();
        while (right < s.length()) {
            char ch = s.charAt(right);
            if (arr[ch] > 0) {
                requiredLength -= 1;
            }
            arr[ch] -= 1;
            while (requiredLength == 0) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    result = s.substring(left, right + 1);
                    System.out.println(result);
                }
                char leftChat = s.charAt(left);
                if (arr[leftChat] == 0)
                    requiredLength += 1;

                arr[leftChat] += 1;
                left += 1;
            }
            right += 1;
        }
        System.out.println(result);
    }

    private static String minWindowBrute(String s, String t) {
        if (s.length() == 0 || t.length() == 0)
            return "";
        int minLength = Integer.MAX_VALUE;
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                if (isValid(sub, t)) {
                    if (sub.length() < minLength) {
                        minLength = sub.length();
                        result = sub;
                    }
                }
            }
        }
        return result;
    }

    private static boolean isValid(String sub, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : sub.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            }
        }
        for (int val : map.values()) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }
}