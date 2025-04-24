class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int countDistinct = 0;
        int len = nums.length;
        HashSet<Integer> hs = new HashSet();

        for(int i = 0; i < len; i ++){
            hs.add(nums[i]);
        }

        countDistinct = hs.size();      

        int ans = 0;

        int l = 0, r = 0;
        HashMap<Integer, Integer> hm = new HashMap();

        while(r < len){
            hm.put(nums[r], hm.getOrDefault(nums[r], 0) + 1);
            
            while(hm.size() == countDistinct && l < len){
                ans += len - r;
                // System.out.println((r - l + 1) + " Count");
                int val = nums[l];
                int freq = hm.get(val);
                if(freq == 1){
                    hm.remove(val);
                }
                else{
                    hm.put(val, freq - 1);
                }

                l ++;
            }

            r ++;
        }

         return ans;
                
    }   
}
