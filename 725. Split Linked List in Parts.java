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
    public ListNode[] splitListToParts(ListNode head, int k) {
        
        // Good question combining math and linked list 
        // Cleaner code can be done by making function of repeating block of code

        // TC: O(N)
        // SC: O(1) not considering the answer array
        
        
        int len = 0;

        ListNode temp = head;

        while(temp != null){
            len ++;
            temp = temp.next;
        }

        int lenEachPart = len / k;

        ListNode ans[] = new ListNode[k];
 
        if(lenEachPart == 0){
            int index = 0;
            ListNode t = head;
            
            while(t != null){
                ans[index ++] = t;
                ListNode nextT = t.next;
                t.next = null;
                t = nextT;
            }

        }
        else{
            
            
            if(lenEachPart * k == len){

                int index = 0;
                ListNode t = head;
                int count = 0;
                ListNode pntToStart = null;
                while(t != null){
                    count ++;
                    if(count == 1) pntToStart = t;
                    if(count == lenEachPart){
                        ans[index ++] = pntToStart;
                        ListNode nextT = t.next;
                        t.next = null;
                        t = nextT;
                        count = 0;
                    }
                    else
                    t = t.next;
                }
            }

            // Last Bit / Part will be not produced by above question in case of uneven distribution
            else{
                
                int index = 0;
                ListNode t = head;
                int count = 0;
                ListNode pntToStart = null;
                for(int i = 0; i < len - lenEachPart * k; i ++){
                       
                        while(t != null){
                            count ++;
                            if(count == 1) pntToStart = t;
                            if(count == lenEachPart + 1){
                                ans[index ++] = pntToStart;
                                ListNode nextT = t.next;
                                t.next = null;
                                t = nextT;
                                count = 0;
                                break;
                            }
                            else
                            t = t.next;
                        }

                }

                
                for(int i = 0; i < k - (len - lenEachPart * k); i ++){
                    while(t != null){
                        if(count == 0) pntToStart = t;
                        count ++;
                        
                        if(count == lenEachPart){
                            ans[index ++] = pntToStart;
                            ListNode nextT = t.next;
                            t.next = null;
                            t = nextT;
                            count = 0;
                        }
                        else
                        t = t.next;
                    }

                   
                }
                 ans[index - 1] = pntToStart;
            }
        }

        return ans;

    }
}
