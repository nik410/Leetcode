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
 *     }2
 * }
 */
class Solution {
    int result = 0;
    int digit[];

    public void dfs(TreeNode root){
        if(root == null){
            return;
        }

         digit[root.val]++;

        if(root.left == null && root.right == null){
            if(palindrome())result++;
        }
        else{
            dfs(root.left);
            dfs(root.right);
        }
        digit[root.val]--;
    }

    public boolean palindrome(){
        int odd = 0;
        for(int i : digit){
            if(i % 2 == 1) odd++;
        }

        if(odd > 1)return false;
        return true;
    }

    public int pseudoPalindromicPaths (TreeNode root) {
        digit = new int[10];

        dfs(root);

        return result;
    }
}
