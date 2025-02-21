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
class FindElements {

    HashSet<Integer> hs;
    Queue<TreeNode> q;

    public FindElements(TreeNode root) {
        q = new LinkedList();
        hs = new HashSet();

        TreeNode rootCopy = root;
        rootCopy.val = 0;
        q.offer(rootCopy);
        hs.add(0);

        while(!q.isEmpty()){
            int siz = q.size();
            for(int i = 0; i < siz; i ++){
                TreeNode tn = q.poll();
                int x = tn.val;

                if(tn.left != null){
                    tn.left.val = 2 * x + 1;
                    q.offer(tn.left);

                    hs.add(tn.left.val);
                }
                if(tn.right != null){
                    tn.right.val = 2 * x + 2;
                    q.offer(tn.right);

                    hs.add(tn.right.val);
                }                
            }
        }

        // System.out.println(hs + " :HS"); 
    }
    
    public boolean find(int target) {
        if(hs.contains(target))return true;
        else return false;
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
