class Solution {
    public long countSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap();
        
        int maxElement = 0;
        for(int i: nums)maxElement = Math.max(maxElement, i);
        // if(nums.length == 1 && k == 1)return 1;
        // if(nums.length == 1 && k > 1)return 0;

        int start = 0, end = 0; long countSub = 0;
        hm.put(maxElement, 0);
        while(end < nums.length){
            hm.put(nums[end], hm.getOrDefault(nums[end], 0) + 1);
           

            while(hm.get(maxElement) >= k){   
                countSub += nums.length - end;              
                hm.put(nums[start], hm.get(nums[start]) - 1);                
                start++;
            }

           
                
            

            end++;

        }

        return countSub;
    }
}
