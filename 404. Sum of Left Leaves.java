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

    //Approach 1
    int sum(TreeNode root, TreeNode parent){
        if(root == null) return 0;

        if(root.left == null && root.right == null){
            if(parent!= null && parent.left == root){
                return root.val;
            }
            return 0;
        }

        int left = sum(root.left, root);
        int right = sum(root.right, root);

         return left + right;
    }

    //Approach 2 using a boolean to check isLeft is true or not

    int sumL(TreeNode root, boolean isLeft){
        if(root == null)return 0;

        if(root.left == null && root.right == null && isLeft == true)return root.val;

        int left = sumL(root.left, true);
        int right = sumL(root.right, false);

        return left + right;
    }

    public int sumOfLeftLeaves(TreeNode root) {
        //return sum(root, null);

        return sumL(root, false);
    }
}
