class Solution {
    public int firstMissingPositive(int[] nums) {
        int l = nums.length, ans = l + 1;

        
        for(int i = 0; i < l; i++){
            int num = nums[i];
            if(num > l || num <= 0){
                nums[i] = 100001;
            }
                                 
        }

        for(int i = 0; i < l; i++){
            int num = Math.abs(nums[i]);
            
            if(num <= l && nums[Math.abs(nums[i]) - 1] >0)
            nums[Math.abs(nums[i]) - 1] *= -1;    

             
        }

        for(int i = 0; i < l; i++){
            if(nums[i] > 0)return i + 1;
        }


        return ans;
    }
}
