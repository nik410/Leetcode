class Solution {

    public int updateFreq(int arr[], int num){
        int bitPlace = 0;
        int valOfOr = 0;
        while(num > 0){
            if(num % 2 == 1)arr[bitPlace] += 1;

            bitPlace ++;
            num /= 2;
        }

          for(int i = 0 ; i < 32; i ++){
                if(arr[i] >=  1)
                valOfOr += Math.pow(2, i);
            }

            return valOfOr;
    }

    public int removeFreq(int arr[], int num){
        int bitPlace = 0;
        
        while(num > 0){
            if(num % 2 == 1)arr[bitPlace] -= 1;

            bitPlace ++;
            num /= 2;
        }

            int valOfOr = 0;
          for(int i = 0 ; i < 32; i ++){
                if(arr[i] >=  1)
                valOfOr += Math.pow(2, i);
            }

            return valOfOr;
    }

    public int minimumSubarrayLength(int[] nums, int k) {
        int l = 0, r = 0;
        int bitFreq[] = new int[32];
        int len = nums.length;
        
        int minLen = Integer.MAX_VALUE;
        while(r < len){
            

            int valOfOr = updateFreq(bitFreq, nums[r]);

          

            while(l <= r && valOfOr >= k){
                minLen = Math.min(minLen, r - l + 1);
                valOfOr = removeFreq(bitFreq, nums[l]);

                l ++;
            }

            r ++;

        }

        if(minLen > (int)(2 * 1e5 + 1))return -1;

        return minLen;
    }
}
