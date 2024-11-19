class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long ans = 0;
        long sum = 0;

        int len = nums.length;

        HashMap<Integer, Integer> hm = new HashMap();
        
        for(int i = 0; i < k; i ++){            
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);            
            sum += nums[i];
        }

        if(hm.size() == k){
            ans = Math.max(ans, sum);
        }

        for(int i = 1; i <= len - k; i ++){
            if(hm.get(nums[i - 1]) == 1){
                hm.remove(nums[i - 1]);
            }
            else if(hm.get(nums[i - 1]) > 1){
                hm.put(nums[i - 1], hm.get(nums[i -1]) - 1);
            }

            hm.put(nums[i + k - 1], hm.getOrDefault(nums[i + k - 1], 0) + 1);

            sum -= nums[i - 1];

            sum += nums[i + k - 1];

            // System.out.println(sum + " :sum" + " i: " + i + " hm: " + hm);

            if(hm.size() == k){
                ans = Math.max(ans, sum);
            }           

        }

        return ans;     

    }
}
