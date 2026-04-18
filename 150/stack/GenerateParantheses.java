import java.util.ArrayList;
import java.util.List;

class GenerateParantheses {

    public static void main(String[] args) {
        int n = 3;
        List<String> result = new GenerateParantheses().generateParenthesis(n);
        System.out.println(result.size());
        System.out.println(result);
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        int open = 0, close = 0;
        generate(open, close, n, result, "");
        return result;
    }

    private void generate(int open, int close, int n, List<String> result, String current) {
        if (open + close == 2 * n) {
            result.add(current);
            return;
        }

        if (open < n)
            generate(open + 1, close, n, result, current + "(");
        if (close < n) {
            if (open > close)
                generate(open, close + 1, n, result, current + ")");
        }
    }

}