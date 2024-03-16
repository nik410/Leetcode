class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap();
        int sum = 0, maxL = 0;
        for(int i = 0; i < n ; i ++){
            if(nums[i] == 0){
                sum -= 1;
            }
            else{
                sum += 1;
            }

            if(sum == 0){
                maxL = Math.max(maxL, i + 1);
            }
            else{
                if(hm.containsKey(sum)){
                     maxL = Math.max(maxL, i - hm.get(sum));
                }
            }

            if(!hm.containsKey(sum)){
                hm.put(sum, i);
            }

        }

        return maxL;
        
    }
}
