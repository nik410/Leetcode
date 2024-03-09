class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int ans = -1;

        int l = 0, r = 0;

        while(l < nums1.length && r < nums2.length){
            int a = nums1[l];
            int b = nums2[r];

            if(a == b){ 
                ans = a;
                break;
            }
            else if(a < b){
                l++;
            }
            else{
                r++;
            }
        }

        return ans;
    }
}
