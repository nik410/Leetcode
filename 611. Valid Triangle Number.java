class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);

        int len = nums.length;

        int ans = 0;

        for(int i = 0; i < len; i ++){
            if(nums[i] == 0)continue;
            for(int j = i + 1; j < len; j ++){
                
                int sumTwoSides = nums[i] + nums[j];

                int l = j, r = len - 1;
                int ind = -1;
                while(l <= r){
                    int mid = l + (r - l) / 2;

                    if(nums[mid] >= sumTwoSides){
                        r = mid - 1;
                    }
                    else{
                         l = mid + 1;
                         ind = mid;
                    }
                }

                // System.out.println("i: " + i + " j: " + j + " ind: " + ind + " count:" + (ind - j + 1));
                ans += (ind - j);
            }
        }

        return ans;
    
    }
}
