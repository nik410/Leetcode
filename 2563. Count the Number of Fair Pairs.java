class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);

        long ans = 0;

        for(int i = 0; i < nums.length; i ++){

            long reqForLower = lower - nums[i];
            long reqForUpper = upper - nums[i];

            int l = i + 1, r = nums.length - 1;
            long r1 = -1;
            while(l <= r){
                int mid = l + (r - l) / 2;
                if(nums[mid] >= reqForLower){
                    r = mid - 1;
                    r1 = mid;
                } 
                else{
                    l = mid + 1;
                }
            }

            // System.out.println("Index: " + i + " R1: " + r1);

            l = i + 1; r = nums.length - 1;

            long r2 = -1;
            while(l <= r){
                int mid = l + (r - l) / 2;
                if(nums[mid] <= reqForUpper){
                    l = mid + 1;
                    r2 = mid;
                } 
                else{
                    r = mid - 1;
                }
            }

            //  System.out.println("Index: " + i + " R2: " + r2);
            
            if((r2 != -1 && r1 != -1) && (r2 != -1 && r1 > -1) && (r2 > -1 && r1 != -1))
            ans += r2 - r1  + 1;

        }

        return ans;
    }
}
