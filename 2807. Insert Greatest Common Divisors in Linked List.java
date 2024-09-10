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

    int gcd(int a, int b){
        if(b == 0)return a;
        return gcd(b, a % b);
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        
        // GCD calculatio using Euclid Theorem

        // TC:O(n * [log(min(a,b))] for GCD Calculation)

        ListNode temp = head;
    
        while(temp != null){
            ListNode nex = temp.next;
            if(nex != null){
                ListNode newNode = new ListNode(gcd(temp.val, nex.val));

                // System.out.println(gcd(temp.val, nex.val)+ " GCD " + " tem: " + temp.val +" nex" + nex.val );
                temp.next = newNode;
                temp = newNode;
                temp.next = nex;
            }
            temp = nex;
        }

        return head;
    }
}
