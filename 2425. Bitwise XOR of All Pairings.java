class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        
        // Important property to remember (a ^ a ^.. ^.. a) is  0 if the frequency of a is even 

        int len1 = nums1.length;
        int len2 = nums2.length;

        int ans = 0;

        if(len2 % 2 != 0){
            for(int i: nums1){
                ans ^= i;
            }
        }

         if(len1 % 2 != 0){
            for(int i: nums2){
                ans ^= i;
            }
        }

        return ans;

    }
}
