class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0;

        int l = 0, r = 0;
        long sum = 1;

        while(r < nums.length){
            sum *= nums[r];

            while(l < r && sum >= k){
                sum /= nums[l];
                l++;
            }
            if(sum < k)
            ans += r  - l + 1;

            r++;
        }

        return ans;
    }
}
