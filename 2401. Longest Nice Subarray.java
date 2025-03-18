class Solution {

    public boolean isRepeat(int currBits[]){
        for(int i: currBits){
            if(i > 1)return true;
        }
        return false;
    }

    public int longestNiceSubarray(int[] nums) {
        int len = nums.length;
        int ans = 0;
        int l = 0, r = 0;
        int currBits[] = new int[32];
        
        while(r < len){
            int val = nums[r];           
            
            for(int j = 0; j < 32 && (val >> j) > 0; j ++){
                int isSet = ((val >> j) & 1);
                if(isSet == 1){
                    currBits[j] ++;
                    
                }
            }

           while(l < r && isRepeat(currBits)){
                val = nums[l];
                 for(int j = 0; j < 32 && (val >> j) > 0; j ++){
                    int isSet = ((val >> j) & 1);
                    if(isSet == 1){
                        currBits[j] --;                        
                    }
                }
                l ++;
            }


            ans = Math.max(ans, r - l + 1);
            r ++;
        }

        return ans;
    }
}
