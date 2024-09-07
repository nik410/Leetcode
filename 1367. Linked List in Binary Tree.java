/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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

    public boolean check(ListNode head, TreeNode root){
        if(head == null)return true;

        if(root == null && head != null)return false;

        if(head.val != root.val)return false;

        return check(head.next, root.left) || check(head.next, root.right);
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        HashSet<TreeNode> hs = new HashSet();
        preOrder(root, hs);

        for(TreeNode n: hs){
            if(check(head, n))return true;
        }

        return false;
        
    }

    public void preOrder(TreeNode root, HashSet<TreeNode> hs){
        if(root == null)return;
        hs.add(root);

        preOrder(root.left, hs);
        preOrder(root.right, hs);
    }
}
