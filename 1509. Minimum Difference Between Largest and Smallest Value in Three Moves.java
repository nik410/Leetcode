class Solution {
    public int minDifference(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;

        if(n <= 3)return 0;
         

        int val1 = Integer.MAX_VALUE;

        val1 = Math.min(val1, nums[n - 4] - nums[0]);

        val1 = Math.min(val1, nums[n - 3] - nums[1]);

        val1 = Math.min(val1, nums[n - 1] - nums[3]);
        
        val1 = Math.min(val1, nums[n -2] - nums[2]);

        return val1;
    }
}
