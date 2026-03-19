
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

// 69
public class TaskScheduler {

    public static void main(String[] args) {
        int n = 2;
        char[] tasks = { 'A', 'B', 'B', 'B', 'A', 'A' };
        int result = leastInterval(tasks, n);
        System.out.println(result);
    }

    public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : tasks)
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.addAll(map.values());

        Queue<int[]> cooldown = new LinkedList<>();

        int time = 0;

        while (!maxHeap.isEmpty() || !cooldown.isEmpty()) {
            time++;

            // Step 1: If something is ready from cooldown, push back to heap
            if (!cooldown.isEmpty() && cooldown.peek()[1] == time) {
                maxHeap.offer(cooldown.poll()[0]);
            }

            // Step 2: Execute task if available
            if (!maxHeap.isEmpty()) {
                int count = maxHeap.poll();
                count--;

                if (count > 0) {
                    cooldown.offer(new int[] { count, time + n + 1 });
                }
            }
            // else → idle automatically (just time passes)
        }

        return time;
    }

}
