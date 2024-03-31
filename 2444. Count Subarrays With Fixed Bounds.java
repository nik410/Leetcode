class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int minIn = -1, maxIn = -1, badIn = -1;
        long ans = 0;
        
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] == minK){
                minIn = i;
            }
            if(nums[i] == maxK){
                maxIn = i;
            }
            if(nums[i] < minK || nums[i] > maxK){
                badIn = i;
            } 

            int smaller = Math.min(maxIn, minIn);

            int temp = smaller - badIn;

            ans += (temp >= 0) ? temp: 0;

        }

        return ans;
    }
}
