class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap();

       int sum = 0, ans  = 0;

       hm.put(0, 1);

        for(int  i = 0; i < nums.length; i ++){
            sum = (sum + nums[i] % k + k) % k;           

            int rem = (sum) % k;
            if(hm.containsKey(rem)){
                ans += hm.get(rem);
            }
           
            hm.put(rem, hm.getOrDefault(rem, 0) + 1);
            

        }

        return ans;
        
   }
}
