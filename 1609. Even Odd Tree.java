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
    public boolean isEvenOddTree(TreeNode root) {
     
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        if(root.val % 2 == 0)return false;
        int level = 1;
        while(!q.isEmpty()){
            int siz = q.size();
            ArrayList<Integer> al =new ArrayList();
            for(int i = 0; i < siz; i++){
                TreeNode popped = q.remove();
                if(popped.left != null){
                    q.add(popped.left);
                    al.add(popped.left.val);
                }
                if(popped.right != null){
                    q.add(popped.right);
                     al.add(popped.right.val);
                }              
            }

              if(level % 2 == 1 && al.size() > 0){
                  if(al.size() == 1 &&al.get(0) % 2 == 1)return false;
                    for(int i = 1; i < al.size(); i++){
                        if(al.get(i - 1) <= al.get(i) || al.get(i - 1) % 2  == 1 ||
                            al.get(i) % 2  == 1)return false;
                    }
                     System.out.println("Yo" + level +"Array: "+ al);
                }
                else if(level % 2 == 0 && al.size() > 0){
                    if(al.size() == 1 &&al.get(0) % 2 == 0)return false;
                     for(int i = 1; i < al.size(); i++){
                        if(al.get(i - 1) >= al.get(i)|| al.get(i - 1) % 2  == 0 ||
                            al.get(i) % 2  == 0)return false;
                    }

                    System.out.println("Yo" + level +"Array: "+ al);
                }
                level++;
        }

        return true;
    }
}
