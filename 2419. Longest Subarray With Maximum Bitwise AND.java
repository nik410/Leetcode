class Solution {
    public int longestSubarray(int[] nums) {
        // So the one thing that a number and its and with any other number apart from
        // itself will (n & any other val of n excluding n) will always be  smaller than n  & n which
        // is equal to n ( n & n == n)

        // The max value palys the significant role here

        int maxValue = 0;

        for(int i: nums){
            maxValue = Math.max(i, maxValue);
        }
        
        int maxAndPossible = maxValue;

        // Now finding the max contiguous subarray having all values as maxValues

        int maxRange = 0;
        int c = 0;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] == maxValue){
                c ++;
            }
            else{
                maxRange = Math.max(maxRange, c);
                c =0;
            }
        }

        if(c != 0){
            maxRange = Math.max(maxRange, c);
        }


        return maxRange;
    }
}
