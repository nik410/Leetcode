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
    public void reorderList(ListNode head) {
        //Finding the mid value 

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;            
        }

        ListNode mid = slow;
        
        //Now reversing the 

        ListNode curr = mid;
        ListNode prev = null;

        while(curr != null){
            ListNode nextP = curr.next;
            curr.next = prev;

            prev = curr;
            curr = nextP;
        }

        // while(prev.next != null){
        //     System.out.println(prev.val +" ");
        //     prev = prev.next;
        // }

        ListNode headOfReversed = prev;

        while(headOfReversed.next != null ){
            ListNode nextAdd = headOfReversed.next;
            ListNode nextHead = head.next;         

            headOfReversed.next = null;
            

            head.next = headOfReversed;
            head = head.next;
            head.next = nextHead;
            head = head.next;
            headOfReversed = nextAdd;


          

        }

    }
}
