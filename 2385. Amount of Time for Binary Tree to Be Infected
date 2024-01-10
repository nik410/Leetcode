// Using ParentNode Concept Time Complexity is  O(n) + O(n) Space Complexity is O(n) + O(n)

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

    public HashMap<Integer, TreeNode> parentF(TreeNode root, TreeNode ref[], int start){
        HashMap<Integer, TreeNode> hm = new HashMap();
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);

        while(!q.isEmpty()){
            int siz = q.size();
            for(int i = 0; i < siz; i++){
                TreeNode prev = q.poll();
                if(prev.val == start) ref[0] = prev;
                if(prev.left != null){
                    q.offer(prev.left);
                    hm.put(prev.left.val, prev);
                }
                if(prev.right != null){
                    q.offer(prev.right);
                    hm.put(prev.right.val, prev);
                }
            }
        }

        return hm;

    }

    public int amountOfTime(TreeNode root, int start) {
        TreeNode ref[] = new TreeNode[1];
        HashMap<Integer, TreeNode> hm = parentF(root, ref, start);
       
        Queue<TreeNode> q = new LinkedList();
        HashSet<TreeNode> visited = new HashSet();
        q.offer(ref[0]);
        visited.add(ref[0]);
        int t = 0;
        while(!q.isEmpty()){
            int siz = q.size();
             for(int i = 0; i < siz; i++){
                TreeNode prev = q.poll();
                if(hm.get(prev.val) != null && !visited.contains(hm.get(prev.val))){
                    q.offer(hm.get(prev.val));
                    visited.add(hm.get(prev.val));
                }
                if(prev.left != null && !visited.contains(prev.left)){
                    q.offer(prev.left);
                    visited.add(prev.left);
                }
                if(prev.right != null && !visited.contains(prev.right)){
                    q.offer(prev.right);
                   visited.add(prev.right);
                }
            }
            if(q.isEmpty())return t;
            t++;
        }

        return t;
    }
}
