class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int longest = 1;
        int countInc = 1, countDec = 1;

        for(int i = 0; i < nums.length - 1; i ++){
            if(nums[i] < nums[i + 1]){
                countInc ++;
                longest = Math.max(longest, Math.max(countInc, countDec));
                countDec = 1;                
            }
            else if(nums[i] > nums[i + 1]){
                countDec ++;
                longest = Math.max(longest, Math.max(countInc, countDec));
                countInc = 1;
            }
            else{
                countDec = 1;
                countInc = 1;
            }

            // System.out.println("Index: " + i + " countDec: " + countDec + " countInc: " + countInc);
        }        

        return longest;
    }
}
