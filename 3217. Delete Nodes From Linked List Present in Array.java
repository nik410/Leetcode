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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> hs = new HashSet();
        for(int i: nums)hs.add(i);

        // System.out.println(hs +" hs");

        ListNode st = new ListNode(-1);
        ListNode dum = st;

        ListNode temp = head;

        while(temp != null){
            if(hs.contains(temp.val)){
                ListNode ptr1 = temp.next;

                while(ptr1 != null && hs.contains(ptr1.val)){
                    ptr1 = ptr1.next;
                }

                dum.next = ptr1;
                dum = ptr1;
                if(ptr1 == null)break;
                temp = ptr1.next;
            }
            else{
                dum.next = temp;
                temp = temp.next;
                dum = dum.next;
            }
        }
        

        return st.next;

        //
    }
}
