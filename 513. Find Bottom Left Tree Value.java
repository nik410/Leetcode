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

 public class Pair{
        TreeNode n;
        int levelwise;
        public Pair(TreeNode n, int levelwise){
            this.n = n;
            this.levelwise = levelwise;
        }
    }
class Solution {
    public int findBottomLeftValue(TreeNode node) {
        int ans = 0;
        Queue<Pair> q = new LinkedList();
        TreeMap<Integer, Integer> tm = new TreeMap();
      
        q.add(new Pair(node, 0));
        tm.put(0, node.val);
      
         while(!q.isEmpty()){
            int siz = q.size();
            for(int i = 0; i < siz; i++){
                Pair p1 = q.poll();
                if(p1.n.left != null){
                    q.add(new Pair(p1.n.left, p1.levelwise + 1));
                        if(!tm.containsKey(p1.levelwise + 1)){
                        tm.put(p1.levelwise + 1, p1.n.left.val);
                      
                       
                          
        
                        }
                }
                
                 if(p1.n.right != null){
                    q.add(new Pair(p1.n.right, p1.levelwise + 1));
                      if(!tm.containsKey(p1.levelwise + 1)){
                        tm.put(p1.levelwise + 1, p1.n.right.val);
                        
        
                          
                      }
                }
            }
           
        }
        
        
        for(int i: tm.keySet()){
            ans = tm.get(i);
        }
        
        return ans;
    }
}
