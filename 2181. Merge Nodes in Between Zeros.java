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
    public ListNode mergeNodes(ListNode head) {

        int sum = 0;
       
        ListNode zeroNode = head;
        ListNode dummy = zeroNode;
        ListNode l1 = head.next;

        while(l1.next != null){
            
            sum += l1.val;
            if(l1.val == 0){
                zeroNode.val = sum;
                sum = 0;
                zeroNode = zeroNode.next;
            }
            l1 = l1.next;
        }

        zeroNode.val = sum;

        zeroNode.next = null;


        return dummy;


        
    }
}
