class Solution {
    public boolean isArraySpecial(int[] nums) {
        int currParity = -1;
        for(int i = 0; i < nums.length; i ++){
            if(i == 0)currParity = (nums[i] & 1);
            else{
                if(currParity == (nums[i] & 1))return false;
                else{
                    currParity = (currParity ^ 1);
                }
            }
        }

        return true;
    }
}
