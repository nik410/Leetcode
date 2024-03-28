class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap();

        int start = 0, end = 0, maxLen = 0;

        while(end < nums.length){
            hm.put(nums[end], hm.getOrDefault(nums[end], 0) + 1);

            while(start < end && hm.get(nums[end]) > k ){
                int num = nums[start];
                start++;
                hm.put(num, hm.get(num) - 1);                
            }

            maxLen = Math.max(maxLen, end - start + 1);
            end++;
        } 

        return maxLen;
    }
}
