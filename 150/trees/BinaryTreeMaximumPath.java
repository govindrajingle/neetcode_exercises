
public class BinaryTreeMaximumPath {

    int maxSum = Integer.MIN_VALUE;

    public static void main(String[] args) {

        // Build the tree
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(-7);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(2);

        BinaryTreeMaximumPath sol = new BinaryTreeMaximumPath();

        int ans = sol.maxPathSum(root);

        System.out.println("Maximum Path Sum = " + ans);
    }

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {

        if (node == null)
            return 0;

        int leftGain = Math.max(0, dfs(node.left));
        int rightGain = Math.max(0, dfs(node.right));

        int currentPath = node.val + leftGain + rightGain;

        maxSum = Math.max(maxSum, currentPath);

        return node.val + Math.max(leftGain, rightGain);
    }
}