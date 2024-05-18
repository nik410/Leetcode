/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    int steps = 0;
    public int dfs(TreeNode root){
        if(root == null)return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        steps += Math.abs(left) + Math.abs(right);

        return (root.val - 1) + left + right;

    }

    public int distributeCoins(TreeNode root) {
        dfs(root);

        return steps;
    }
}
