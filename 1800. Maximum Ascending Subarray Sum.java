class Solution {
    public int maxAscendingSum(int[] nums) {
        int sumMax = nums[0];
        int sumCurr = nums[0];

        for(int i = 0; i < nums.length - 1; i ++){
            sumMax = Math.max(sumMax, nums[i]);

            if(nums[i] < nums[i + 1]){
                sumCurr += nums[i + 1];
            }
            else{                
                sumCurr = nums[i + 1];
            }
            sumMax = Math.max(sumMax, sumCurr);

            // System.out.println("Index: " + i + " sumMax:" + sumMax + " sumCurr: " + sumCurr);
        }


        return sumMax;
    }
}
