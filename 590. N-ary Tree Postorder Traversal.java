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

    // public void postOrder(Node root, List<Integer> al){
    //     if(root == null){            
    //         return;
    //     }

    //     for(Node n: root.children){
    //         postOrder(n, al);
    //         al.add(n.val);
    //     }
    // }

    public List<Integer> postorder(Node root) {
    //     if(root == null){
    //         return new ArrayList<Integer>();
    //     }
    //     List<Integer> al = new ArrayList();
    //     postOrder(root, al);
    //     al.add(root.val);
    //     return al;

    // Iterative

    if(root == null)return new ArrayList();

    List<Integer> al = new ArrayList();

    Stack<Node> st1 = new Stack();
    Stack<Integer> st2 = new Stack();

    st1.push(root);

    while(!st1.isEmpty()){
        Node temp = st1.pop();
        st2.push(temp.val);

        for(Node n: temp.children){
            st1.push(n);
        }
    }

    while(!st2.isEmpty()){
        al.add(st2.pop());
    }

    return al;

}
}
