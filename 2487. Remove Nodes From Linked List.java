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
    public ListNode removeNodes(ListNode head) {
       ListNode curr = head;
       ListNode prev = null;
       ListNode nextPo = null;

       while(curr != null){
            nextPo = curr.next;
            curr.next = prev;

            prev = curr;
            curr = nextPo;
       }

    //    return prev;
        
       ListNode newHead = prev.next;
       ListNode prevNode = prev;
       int largest = prev.val;
       while(newHead != null){
        ListNode nextNode = newHead.next;
        if(newHead.val < largest){
            prevNode.next = nextNode;
            }
        else{
            largest = Math.max(largest, newHead.val);
            prevNode = newHead;
        }
        newHead = nextNode;
       }

        ListNode prevTemp = prev;
        ListNode prevT = null;

        while(prevTemp != null){
            ListNode nextN = prevTemp.next;
            prevTemp.next = prevT;

            prevT = prevTemp;
            prevTemp = nextN;

        }

       return prevT;





    }
}
