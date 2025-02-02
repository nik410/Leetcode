class Solution {
    public boolean check(int[] nums) {
        int countDip = 0;

        for(int i = 0; i < nums.length; i ++){
            
            if(i == nums.length - 1){
                if(nums[0] < nums[i])countDip ++;
                break;
            }

            if(nums[i + 1] < nums[i])countDip ++;
        }

        if(countDip > 1)return false;
        else return true;
    }
}
