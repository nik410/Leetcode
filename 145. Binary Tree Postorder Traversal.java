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

    // public void postOrder(TreeNode root, List<Integer> al){
    //     if(root == null)return;

    //     postOrder(root.left, al);
    //     postOrder(root.right, al);
    //     al.add(root.val);
    // }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> order = new ArrayList();
        // postOrder(root, order);
        // return order;

        while(root != null){
            if(root.right == null){
                order.add(root.val);
                root = root.left;
            }
            else{
                TreeNode rightC = root.right;

                while(rightC.left != null && rightC.left != root){
                    rightC = rightC.left;
                }

                if(rightC.left == null){
                     order.add(root.val);
                    rightC.left = root;
                    root = root.right;
                }
                else{
                    
                    root = root.left;
                }
            }
        }

        // As we know post order is Left Right Node but morris travesal will be difficult for it so we reverse the order to Node Right left which is similar to preoder
        
        List<Integer> ans = new ArrayList();
        for(int i = order.size() - 1; i >= 0; i --){
            ans.add(order.get(i));
        }
        return ans;
    }
}
