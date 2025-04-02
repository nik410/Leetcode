class Solution {
    public long maximumTripletValue(int[] nums) {
        int len = nums.length;
        long ans = 0;
        int maxSuff[] =  new int[len];
        for(int i = len - 1; i >= 0; i --){
            if(i == len - 1){
                maxSuff[i] = nums[i];
            } 
            else{
                maxSuff[i] = Math.max(maxSuff[i + 1], nums[i]);
            }
        }
        int maxPref[] = new int[len];
     
        for(int i = 0; i < len; i ++){

            if(i == 0){
                maxPref[i] = nums[i];
            } 
            else{
                maxPref[i] = Math.max(maxPref[i - 1], nums[i]);
            }          
        
        }

        for(int i = 1; i < len - 1; i ++){
            int val = nums[i];
            ans = Math.max(ans, (maxPref[i - 1] - val) * (long)maxSuff[i + 1]);
        }

        return ans;
        
    }
}
