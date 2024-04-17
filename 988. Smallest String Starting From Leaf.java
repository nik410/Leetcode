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
    public void smallest(TreeNode root, StringBuilder stb, ArrayList<String> al){

        if(root == null)return;
        
        if(root.left == null && root.right == null){  
             stb.append((char)(97 + root.val));          
            al.add(new String(stb.reverse().toString()));
            stb.setLength(0);
            
        }
        stb.append((char)(97 + root.val));
        smallest(root.left, new StringBuilder(stb), al);
        if(stb.length() > 0)stb.delete(stb.length() - 1, stb.length());


        stb.append((char)(97 + root.val));
        smallest(root.right, new StringBuilder(stb), al);
        if(stb.length() > 0)stb.delete(stb.length() - 1, stb.length());
    


    }

    static class Pair{
        TreeNode node;
        StringBuilder stb;

        Pair(TreeNode node,StringBuilder stb){
           this.node = node;
           this.stb = stb;
        }
    }

    public String smallestFromLeaf(TreeNode root) {
        // StringBuilder stb = new StringBuilder();
        ArrayList<String> al = new ArrayList();
        // smallest(root, stb, al);

        // Collections.sort(al);
        // // System.out.println(al);
        // return al.get(0);
        StringBuilder stb = new StringBuilder();
        Queue<Pair> q = new LinkedList();
        stb.append((char)(97 + root.val));
        q.offer(new Pair(root, stb));
        String ans ="";
        while(!q.isEmpty()){
            int siz = q.size();
            for(int i = 0; i < siz; i++){
                Pair temp = q.peek();
                
                if(temp.node.left == null && temp.node.right == null){
                    int compare = ans.compareTo(temp.stb.toString());
                   al.add(temp.stb.toString());
                   
                }

                if(temp.node.left != null){
                    StringBuilder s = new StringBuilder(temp.stb);
                     s.insert(0, (char)(temp.node.left.val + 97));
                    //System.out.println(s+" :ansLeft");
                     q.offer(new Pair(temp.node.left, s));
                }
                if(temp.node.right != null){
                   StringBuilder s = new StringBuilder(temp.stb);
                    s.insert(0, (char)(temp.node.right.val + 97));
                    //System.out.println(s+" :ansRight");
                    q.offer(new Pair(temp.node.right, s));
                }

                
                q.poll();
            }

        }
        
        Collections.sort(al);
        return al.get(0);
    }
}
