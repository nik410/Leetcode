class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        // HashMap<Integer, Integer> hm = new HashMap();
        // int oddCount = 0, ans = 0;
        // hm.put(0, 1);
        // for(int i = 0; i < nums.length; i ++){
        //     if(nums[i] % 2 == 1){
        //         oddCount ++;
        //     }

        //     if(hm.containsKey(oddCount - k)){
        //         ans += hm.get(oddCount - k);
        //     }

        //     hm.put(oddCount, hm.getOrDefault(oddCount, 0) + 1);
        // }

        // return ans;

        // // TC: O(n) SC: O(n)


        int l = 0, r = 0, ans = 0, prev = 0, oddCount = 0;

        while(r < nums.length){
            if(nums[r] % 2 == 1){
                oddCount ++;
                prev = 0;
            }

            while(oddCount == k){
                prev ++;

               if(l <= r && nums[l] % 2 == 1){
                    oddCount --;                    
                    
                }
                l ++;
            }

            ans += prev;
            r++;
        }


        return ans;       
    }
}
