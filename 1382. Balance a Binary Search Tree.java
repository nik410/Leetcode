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

    public void inOrder(TreeNode root, ArrayList<Integer> al){
        if(root == null)return;

        inOrder(root.left, al);
        al.add(root.val);
        inOrder(root.right, al);
    }

    public TreeNode solve(int l, int r, ArrayList<Integer> al){
        if(l > r)return null;

        int mid = (l + r) / 2;

        TreeNode root = new TreeNode(al.get(mid));
        root.left = solve(l, mid - 1, al);
        root.right = solve(mid + 1, r, al);

        return root;
    }

    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> al = new ArrayList();
        inOrder(root, al);

        return solve(0, al.size() - 1, al);
    }
}
