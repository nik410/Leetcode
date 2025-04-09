class Solution {
    public int minOperations(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap();

        for(int i = 0; i < nums.length; i ++){
            int val = nums[i];
            if(val < k)return -1;
            if(val > k)
            hm.put(val, hm.getOrDefault(val, 0) + 1);
        }

        // int occuranceOfK = 0;

        // if(hm.containsKey(k))occuranceOfK = hm.get(k);

        // if(occuranceOfK == nums.length)return 0;

        return hm.size();
    }
}
