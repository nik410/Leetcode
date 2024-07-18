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

    public void makeGraph(TreeNode root, TreeNode prev, Map<TreeNode, List<TreeNode>> adj, Set<TreeNode> leafNodes) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) { // Leaf node
            leafNodes.add(root);
        }

        if (prev != null) {
            adj.computeIfAbsent(root, k -> new ArrayList<>()).add(prev);
            adj.computeIfAbsent(prev, k -> new ArrayList<>()).add(root);
        }

        makeGraph(root.left, root, adj, leafNodes);
        makeGraph(root.right, root, adj, leafNodes);
    }

    public int countPairs(TreeNode root, int distance) {
        Map<TreeNode, List<TreeNode>> adj = new HashMap<>(); // Graph
        Set<TreeNode> leafNodes = new HashSet<>(); // Leaf nodes

        makeGraph(root, null, adj, leafNodes);

        int count = 0; // Count of good node pairs

        for(TreeNode t: leafNodes){

            Queue<TreeNode> q = new LinkedList();
            Set<TreeNode> visited = new HashSet();
            q.add(t);
            visited.add(t);

            int dist;
            for(dist = 0; dist <= distance; dist ++){
                int siz = q.size();
                while(siz -- > 0){
                    TreeNode temp = q.poll();
                
                    // System.out.println("Distance: " + dist + "Temp: " + temp.val);
                    if (temp != t && leafNodes.contains(temp)) {
                        
                            count++;
                    }

                    for(TreeNode node: adj.getOrDefault(temp, new ArrayList<TreeNode>())){
                        if(!visited.contains(node)){
                            q.add(node);
                            visited.add(node);
                        }
                    }              
                }
            }
             

        }

        return count / 2;
    }
}
