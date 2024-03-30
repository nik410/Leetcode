class Solution {

    public int subArrayC(int nums[], int k){
        HashMap<Integer, Integer> hm = new HashMap();
        int start = 0, end = 0, ansC = 0;

        while(end < nums.length){
            hm.put(nums[end], hm.getOrDefault(nums[end], 0) + 1);
           
            while(start < end && hm.size() > k){
                if(hm.get(nums[start]) == 1){
                    hm.remove(nums[start]);
                }
                else{
                    hm.put(nums[start], hm.get(nums[start]) - 1);
                }
                start++;
            }

            ansC += end - start + 1;

            end++;
        }

        return ansC;

    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        if(k == 1)return subArrayC(nums, k);
       else return subArrayC(nums, k) - subArrayC(nums, k - 1);

    }
}
