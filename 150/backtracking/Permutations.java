import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        new Permutations().permute(nums, current, result, visited);
        for (List<Integer> data : result) {
            System.out.print(data + " ");
        }
    }

    public void permute(int[] nums, List<Integer> current, List<List<Integer>> result,
            boolean[] visited) {
        // the break case (does i got any of the possible solution)
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            current.add(nums[i]);
            permute(nums, current, result, visited);
            // undo all changes for given solution
            visited[i] = false;
            current.remove(current.size() - 1);
        }
    }
}
