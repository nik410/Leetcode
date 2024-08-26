/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> al = new ArrayList();

        if(root == null)return al;

        Queue<Node> q = new LinkedList();

        q.offer(root);

        while(!q.isEmpty()){
            
            int siz = q.size();
            List<Integer> lev = new ArrayList();
            for(int i = 0; i < siz; i ++){
                Node temp = q.poll();
                lev.add(temp.val);
                for(Node n: temp.children){
                    q.offer(n);
                }
            }
            al.add(lev);
           
        }

        return al;
    }
}
