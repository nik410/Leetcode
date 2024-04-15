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

    public int sum(TreeNode root, int curr){
       if(root == null)return 0;

       curr = curr * 10 + root.val;

       if(root.left == null && root.right == null){           
            return curr;
       }

       int sumL = sum(root.left, curr);
       int sumR = sum(root.right, curr);

       return sumL + sumR;

    }

    public int sumNumbers(TreeNode root) {       
        return  sum(root, 0);
    }
}
