class Solution {
    public int specialArray(int[] nums) {
        int low = 0, high = nums.length;

        while(low <= high){
            int mid = low + (high - low) / 2;
            
            int c = 0;

            for(int i: nums){
                if(i >= mid)c++;
            }

            if(c == mid)return mid;

            if(c > mid){
                low = mid + 1;
            }
            else if(c < mid){
                high = mid - 1;
            }
           
        }

        return -1;
    }
}
