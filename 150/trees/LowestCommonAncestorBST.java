public class LowestCommonAncestorBST {
    // 5
    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        // As this is bst simply follow the DFS
        if (root == null)
            return null;
        // There are three cases of p and q nodes. Either both are left or right or one
        // is left and other is right
        // Solution is where you can't determaine to left or right
        if (root.val > p.val && root.val > q.val)
            return lca(root.left, p, q);
        if (root.val < p.val && root.val < q.val)
            return lca(root.right, p, q);
        return root;
        // O(height);
        // O(n) if tree is linear
    }
}
