/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        
        HashMap<Integer, ListNode> hm = new HashMap();
        ListNode temp = new ListNode(0);
        hm.put(0, temp);
        temp.next = head;
        ListNode headCopy = temp;
        int sum =0;
        while(headCopy != null){
            sum += headCopy.val;

            if(hm.containsKey(sum)){
                ListNode prevNode = hm.get(sum);
               
                int ps = sum;           
                ListNode copyPrev = prevNode;
                while(copyPrev != headCopy){
                    copyPrev = copyPrev.next;
                    ps += copyPrev.val;
                    if(copyPrev != headCopy)                    
                    hm.remove(ps);
                }

                 prevNode.next = headCopy.next;    
            }

            else{
            hm.put(sum, headCopy);
            }
            headCopy = headCopy.next;
        }

        return temp.next;
    }
}
