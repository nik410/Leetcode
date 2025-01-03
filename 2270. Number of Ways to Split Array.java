class Solution {
    public int waysToSplitArray(int[] nums) {
        long sum = 0;

        for(int i: nums){
            sum += i;
        }

        // Use of long datatype is important as the use of int datatype 
        // is causing some overflow issues that is the sum exceeds max limit of integer( -2^32, 2^32 - 1)

        int ans = 0;
        long leftSum = 0;

        for(int i = 0; i < nums.length - 1; i ++){
            leftSum += nums[i];
            long rightSum = sum - leftSum;
            if(leftSum >= rightSum){
                ans ++;
                
            }
            // System.out.println("leftSum: " + leftSum + " rightSum: " + rightSum + " index: " + i);
        }

        return ans;
    }
}
