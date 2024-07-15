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
        int val;
        char side;
        Pair(int val, char side){
            this.val = val;
            this.side = side;
        }
    }
    public TreeNode createBinaryTree(int[][] descriptions) {
        // HashMap<Integer, Integer> freqNode = new HashMap();
        HashMap<Integer, TreeNode> hm = new HashMap();
        HashSet<Integer> set = new HashSet();
        for(int i = 0; i < descriptions.length; i ++){
            int parentNode = descriptions[i][0]; 
            int childNode = descriptions[i][1]; 

            set.add(parentNode);
            

            char dir;
            if(descriptions[i][2] == 1){
                dir = 'L';
            }
            else{
                dir = 'R';
            }

           

            if(!hm.containsKey(parentNode) && !hm.containsKey(childNode)){
                TreeNode newNode = new TreeNode(parentNode);
                TreeNode sideNode = new TreeNode(childNode);

                if(dir == 'L'){
                    newNode.left = sideNode;
                }
                if(dir == 'R'){
                    newNode.right = sideNode;
                }

                hm.put(childNode, sideNode);
                hm.put(parentNode, newNode);

            }
            
            else if(!hm.containsKey(parentNode) && hm.containsKey(childNode)){
                TreeNode newNode = new TreeNode(parentNode);
                TreeNode sideNode = hm.get(childNode);

                if(dir == 'L'){
                    newNode.left = sideNode;
                }
                if(dir == 'R'){
                    newNode.right = sideNode;
                }
                
                hm.put(childNode, sideNode);
                hm.put(parentNode, newNode);

            }

             else if(hm.containsKey(parentNode) && !hm.containsKey(childNode)){
                TreeNode newNode = hm.get(parentNode);
                TreeNode sideNode = new TreeNode(childNode);

                if(dir == 'L'){
                    newNode.left = sideNode;
                }
                if(dir == 'R'){
                    newNode.right = sideNode;
                }
                
                hm.put(childNode, sideNode);
                hm.put(parentNode, newNode);

            }
            else{
                TreeNode newNode = hm.get(parentNode);
                TreeNode sideNode = hm.get(childNode);

                if(dir == 'L'){
                    newNode.left = sideNode;
                }
                if(dir == 'R'){
                    newNode.right = sideNode;
                }
                
                hm.put(childNode, sideNode);
                hm.put(parentNode, newNode);
            }
           
        }

        for(int i = 0; i < descriptions.length; i ++){
            set.remove(descriptions[i][1]);
        }

        TreeNode rootNode = null;

        for(int i: set){
            // System.out.println(i + " :i'");
            rootNode = hm.get(i);
        }

        return rootNode;
        
    }
}
