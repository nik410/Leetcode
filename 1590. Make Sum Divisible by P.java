class Solution {
    public int minSubarray(int[] nums, int p) {
        HashMap<Long, Integer> hm = new HashMap();
        long totalSum = 0;

        for(int i = 0; i < nums.length; i ++){
            totalSum += nums[i];
        }

        if(totalSum % p == 0)return 0;

        if(totalSum < p)return -1;

        long modT = totalSum % p;

        hm.put((long)0, -1);

        long preSum = 0;
        
        long minLength = nums.length;

        for(int i = 0; i < nums.length; i ++){
            preSum += nums[i];
            
            if(hm.containsKey(((preSum - modT)% p  + p) % p)){
                minLength = Math.min(minLength, i - hm.get(((preSum - modT)% p  + p) % p));
            }
                       
            hm.put(preSum % p, i);

        }

        if(minLength == nums.length)return -1;
        else
        return (int)minLength;   
    }
}
