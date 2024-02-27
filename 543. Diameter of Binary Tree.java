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

    public int diameter(TreeNode root, int arr[]){
        if(root == null)return 0;
       
        int ans = 0;
        int left = diameter(root.left, arr);
        int right = diameter(root.right, arr);
        arr[0] = Math.max(arr[0], 1 + left + right);
        return 1 + Math.max(left , right);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int arr[] = new int[1];
        diameter(root, arr);

        return arr[0] - 1;
    }
}
