class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        // int max = 0;
        // for(int i: nums){
        //     max = Math.max(i, max);
        // }

        // int diffArr[] = new int[max + 1];

        // for(int i = 0; i < nums.length; i ++){
        //     for(int j = i + 1; j < nums.length; j ++){
        //         int diff = Math.abs(nums[i] - nums[j]);
        //         diffArr[diff] ++;
        //     }
        // }
        // // System.out.println("-----------");
        // // for(int i: diffArr)System.out.print(i + " ");
        // int in = 0;
        // while(k > 0 && in < max + 1){
        //     k -= diffArr[in];            
        //     if(k <= 0)return in;
        //     in ++;
        // }

        // return -1;

        Arrays.sort(nums);
        int n = nums.length;
        int l = 0, r = nums[n - 1] - nums[0];
        int res = -1;
        while(l <= r){
            int mid = r + (l - r) / 2;

            int pairN = pairs(nums, mid);

            if(pairN < k){
                l = mid + 1;
            }
            else if(pairN >= k){
                res = mid;
                r = mid - 1;
            }           
        }

        return res;
    }

    public int pairs(int nums[], int mid){
        int l = 0, r = 1;
        int pairs = 0;

        while(r < nums.length){

            while(nums[r] - nums[l] > mid){
               l ++;
            }

            pairs += (r - l);

            r ++;
        }

        return pairs;
    }

}
