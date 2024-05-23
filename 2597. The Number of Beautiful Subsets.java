class Solution {

    public void ways(int nums[], int index, int k, HashMap<Integer, Integer> hm, int ans[]){
        if(index == nums.length){
            //System.out.println(hs);
            int flag = 0;
            for(int i: hm.keySet()){
                if(hm.containsKey(i - k) || hm.containsKey(i + k)){
                    return;
                    }
            }
            ans[0]++;
        
            return;
        }
        int curr = nums[index];
        hm.put(nums[index], hm.getOrDefault(nums[index], 0) + 1);        
        ways(nums, index + 1, k, hm, ans);
        if(hm.get(curr) == 1)
            hm.remove(curr);
        else{
             hm.put(nums[index], hm.getOrDefault(nums[index], 0) - 1);
        }


        ways(nums, index + 1, k, hm, ans);        
    }

    public int beautifulSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        HashMap<Integer, Integer> hm = new HashMap();
        int ans[] = new int[1];
        ways(nums, 0, k, hm, ans);
        return ans[0] - 1;
    }
}
