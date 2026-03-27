// The node with value X is said to good node if the nodes present between root and X nodes has values less that or equal to X. if there are n nodes in between x and root, then n.val <= x.val.
// [3,1,4,3,null,1,5]

// leftChild = 2*i+1, rightChild = 2*i+2

//                 3
//              1      4
//            3      1   5

public class GoodNodeInTree {

    int count = 0;

    public int countGoodNodes(TreeNode root) {
        dfs(root, root.val);
        return count;
    }

    public void dfs(TreeNode node, int maxSoFar) {
        if (node == null)
            return;
        if (node.val >= maxSoFar)
            count += 1;
        int newMax = Math.max(maxSoFar, node.val);
        dfs(node.left, newMax);
        dfs(node.right, newMax);
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {

    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}