import java.util.Arrays;

// 746
public class MinCostClimbingStairs {

    public static void main(String[] args) {
        int[] cost = { 4, 8, 7, 6, 2 };
        int minCost = getMinCost(cost);
        System.out.println(minCost);
    }

    // you could also use the recursion with 2 decisions either take 1 or 2 steps at
    // any point. It will take a lot time to solve same index cost in every
    // decision, to optimize that you will create an extra array to store result of
    // each decision. So you already need a extra array, follow the normal iteration
    // and keep on storing updated min cost for each index either 1 step or 2 steps.

    // Remember start the loop from i=2 and new array space should be +1 with
    // provided array

    private static int getMinCost(int[] cost) {
        int[] minCost = new int[cost.length + 1];
        Arrays.fill(minCost, 0);
        for (int i = 2; i <= cost.length; i++) {
            minCost[i] = Math.min(
                    // move 1 step
                    cost[i - 2] + minCost[i - 2],
                    // move 2 steps
                    cost[i - 1] + minCost[i - 1]);
        }
        return minCost[minCost.length - 1];
    }
}
