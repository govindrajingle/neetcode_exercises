import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 109
public class WordBreak {

    static int n;

    public static void main(String[] args) {
        String s = "abxcdfggp";
        List<String> wordDict = List.of("a", "bxcd", "fg", "gp");
        int n = s.length() - 1;
        System.out.println(solve(0, 0, s, new HashSet<>(wordDict)));
    }

    public static boolean solve(int start, int end, String s, Set<String> wd) {
        // Check the entire sub string
        if (end == n) {
            String word = s.substring(start, end + 1);
            if (wd.contains(word)) {
                return true;
            }
            return false;
        }

        // Found the sub string
        String word = s.substring(start, end + 1);
        if (wd.contains(word)) {
            boolean res = solve(end + 1, end + 1, s, wd);
            if (res) {
                return true;
            }
        }

        // Not found substring
        return solve(start, end + 1, s, wd);
    }

}
