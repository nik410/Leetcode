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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int ans[][] = new int[m][n];

        int left = 0, right = n - 1, top = 0, bot = m - 1;

        while(top <= bot && left <= right){

            //Left to Right
            if(top <= bot){
                for(int i = left; i <= right; i ++){
                    if(head == null)head = new ListNode(-1);
                    ans[top][i] = head.val;
                    head = head.next;
                }
                
                top ++;
            }
            // Top to down

            if(left <= right){

                for(int i = top; i <= bot; i ++){
                    if(head == null)head = new ListNode(-1);
                    ans[i][right] = head.val;
                    head = head.next;
                }

                right --;
            }

            // Right to Left
            if(top <= bot){
                for(int i = right; i >= left; i --){
                    if(head == null)head = new ListNode(-1);
                    ans[bot][i] = head.val;
                    head = head.next;

                }
                bot --;
            }
            // Bottom to Top
            if(left <= right){
                for(int i = bot; i >= top; i --){
                    if(head == null)head = new ListNode(-1);
                    ans[i][left] = head.val;
                    head = head.next;
                }

                left ++;
            }

        }


        return ans;

    }
}
