class Solution {
    public int findDuplicate(int[] nums) {
      
      int ans = 0;

      for(int i = 0; i < nums.length; i++){
        if( nums[Math.abs(nums[i])] < 0){
            ans = Math.abs(nums[i]); break;
           }
 
        nums[Math.abs(nums[i])] *= -1 ;
      }

      return ans;

    }
}
