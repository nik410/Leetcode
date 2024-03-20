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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        
        //Finding the node where the list2 start is to be inserted

        ListNode first = list1;
        int c = a - 1;
        while(c -- > 0){
            first = first.next;
        }

        //Finding the last node where the ll2 end will join the ll1 nodes
       
        ListNode last = list1;
         int c1 = b;
        while(c1 -- > 0){
            last = last.next;
        }       
        //Finding the last node of ll2 

        ListNode lastOfLL2 = list2;

        while(lastOfLL2.next != null){
            lastOfLL2 = lastOfLL2.next;
        }
        // System.out.println(first.val + " " + last.val);
       //The linking of ll 2 start to the position of ath node in ll2 and end of ll2 in ll1 last pos
       
        first.next = list2;
        lastOfLL2.next = last.next;

        return list1;
    }
}
