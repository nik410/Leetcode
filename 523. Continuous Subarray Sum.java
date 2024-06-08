class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer, Integer> hm = new HashMap();
        for(int i = 0; i < nums.length; i ++){
            sum += nums[i];
            if(sum % k == 0){
                if(i + 1 >= 2)
                return true;
            }
            int mod = sum % k;

            if(hm.containsKey(mod)){
                if(i - hm.get(mod) >=  2)
                return true;
                }
            else{
                hm.put(mod, i);
            }
        }

        return false;
    }
}
