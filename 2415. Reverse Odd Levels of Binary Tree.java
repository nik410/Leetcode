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

    class Pair{
        TreeNode node;
        int level;

        Pair(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }

    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<Pair> q = new LinkedList();
        int currLevel = 0;
        q.offer(new Pair(root, currLevel));

        while(!q.isEmpty()){
            int siz = q.size();

            TreeNode arr[] = new TreeNode[siz]; 
            
            for(int i = 0; i < siz; i ++){
                Pair t = q.poll();
                
                if(t.node.left != null)q.offer(new Pair(t.node.left, t.level + 1));
                if(t.node.right != null)q.offer(new Pair(t.node.right, t.level + 1));

                arr[i] = t.node;                  
            }

             if (currLevel % 2 == 1) {
                for (int i = 0; i < siz / 2; i++) {
                    
                    int temp = arr[i].val;
                    arr[i].val = arr[siz - 1 - i].val;
                    arr[siz - 1 - i].val = temp;
                }
            }

            currLevel ++;

            
        }

        return root;
        
    }
}
