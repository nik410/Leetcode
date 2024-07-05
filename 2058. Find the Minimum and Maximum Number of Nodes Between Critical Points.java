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

Approach one : Using sorting TC increases
 
// class Solution {
//     public int[] nodesBetweenCriticalPoints(ListNode head) {
        
//         ArrayList<Integer> al = new ArrayList();

//         ListNode prev = head;
//         ListNode l1 = head.next;
//         int index = 2;

//         while(l1.next != null){
//             if(( prev.val > l1.val && l1.next.val > l1.val ) || ( prev.val < l1.val && l1.next.val < l1.val )){
//                 al.add(index);
//             }
//             prev = l1;
//             l1 = l1.next;
//             index++;
//         }


//         System.out.println(al);

//         if(al.size() < 2)
//             return new int[]{-1, -1};
//         else{
//             Collections.sort(al);

//             int ans[] = new int[2];
//             ans[1] = al.get(al.size() - 1) - al.get(0);

//             int min = Integer.MAX_VALUE;
//             for(int i = 0; i < al.size() - 1; i ++){
//                 min = Math.min(al.get(i + 1) - al.get(i), min);
//             }

//             ans[0] = min;

//             return ans;
//         }
//     }
// }


    Approach 2: greddy approach gets it done in O(n)

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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        
        ArrayList<Integer> al = new ArrayList();

        ListNode prev = head;
        ListNode l1 = head.next;
        int index = 2;

        int firstIndex = -1, prevIndex = -1, minDis = (int)1e6, maxDis = 0;

        while(l1.next != null){
            if(( prev.val > l1.val && l1.next.val > l1.val ) || ( prev.val < l1.val && l1.next.val < l1.val )){
               
            

            if(firstIndex == -1){
                prevIndex = index;
                firstIndex = index;
            }
            else{
                minDis = Math.min(minDis, index - prevIndex);
                maxDis = Math.max(maxDis, index -  firstIndex);
                prevIndex = index;
            }
        }
            prev = l1;
            l1 = l1.next;
            index++;
    }

        int ans[] = {minDis, maxDis};

        if(ans[0] == 1000000)return new int[]{-1, -1};

       

        return ans;
        
    }
}
