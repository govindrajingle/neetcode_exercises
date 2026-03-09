public class DFS {
    public static void inOrder(TreeNode root) {
        // Left -> Root -> Right
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }
}
