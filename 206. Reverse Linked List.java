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

    // public static ListNode reverse(ListNode curr, ListNode prev, ListNode nextNode){
    //     if(curr == null){
    //         return prev;
    //     }
    //     else{
    //         nextNode = curr.next;
    //         curr.next = prev;
    //         return reverse(nextNode, curr, null);
    //     }
    // }

    public ListNode reverseList(ListNode head) {
        // return reverse(head, null, null);

        ListNode curr = head;
        ListNode prev = null;

        while(curr != null){
            ListNode nextPointer = curr.next;
            curr.next = prev;

            prev = curr;
            curr = nextPointer;            
         }

        return prev;
    }
}
