/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode nextNode = node.next;
        //Swapping values of the nextNode and node to be deleted
        int temp = nextNode.val;
        nextNode.val = node.val;
        node.val = temp;

        //Deleting(or breaking) the nextNode with node value from linked list 
        node.next = nextNode.next;

        
    }
}
