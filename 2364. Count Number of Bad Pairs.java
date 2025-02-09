class Solution {
    public long countBadPairs(int[] nums) {
        //Bruteforce 
        // Will give TLE as the number of elements can go upto 10^5
        // TC: O(n^2)

        // int len = nums.length;

        // long count = 0;

        // for(int i = 0; i < len; i ++){
        //     for(int j = i + 1; j < len; j ++){
        //         if(j - i != nums[j] - nums[i]){
        //             count ++;
        //         }
        //     }
        // }

        // return count;

        // Optimal 
        // Always when given equation in a problem try to shuffle it
        // Or change the way it is written to look in a new direction
        // j - i != nums[j] - nums[i] can be written as nums[i] - i != nums[j] - j

        int len = nums.length;
        long count = 0;

        for(int i = 0; i < len; i ++){
            nums[i] = nums[i] - i;
        }

        HashMap<Integer, Integer> hm = new HashMap();

        for(int i = 0; i < len; i ++){
            if(hm.containsKey(nums[i])){
                count += (i) - hm.get(nums[i]);
            }
            else{
                count += i;
            }
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }

        return count;

    }
}
