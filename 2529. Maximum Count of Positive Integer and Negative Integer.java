class Solution {
    public int maximumCount(int[] nums) {
        
        // int pos = 0;
        // int zero = 0;
        // for(int i: nums){
        //     if(i > 0)pos ++;
        //     if(i == 0)zero ++;
        // }

        // return Math.max(pos, nums.length - zero - pos);

        // Binary Search
        int len = nums.length;

        if(len == 1 && (nums[0] > 0 || nums[0] < 0))return 1;

        int l = 0, r = len;
        int neg = -1;
        while(l < r){
            int mid = l + (r - l) / 2;
            if(nums[mid] >= 0){
                r = mid;
            }
            else{
                neg = Math.max(mid, neg);
                l = mid + 1;
            }
        }

        int pos = len + 1;
        l = 0; r = len - 1;

          while(l < r){
            int mid = l + (r - l) / 2;
            if(nums[mid] <= 0){
                l = mid + 1;
            }
            else{
                pos = Math.min(mid, pos);
                r = mid;
            }
        }

        // System.out.println(neg + " pos: " + pos);

        // if(pos == len + 1)return len;

        return Math.max(neg + 1, len - pos);

    }
}
