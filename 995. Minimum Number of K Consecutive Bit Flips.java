
class Solution {
    public int minKBitFlips(int[] nums, int k) {
        // int n = nums.length;
        // int flips = 0;
        // int fC = 0;
        
        // for (int i = 0; i < n; i++) {
          
        //   if(i >= k && nums[i - k] == 10){
        //     fC --;
        //   }

        //   if(fC % 2 == nums[i]){
        //     if(i + k > n)return -1;

        //     flips ++;
        //     fC ++;
        //     nums[i] = 10;

        //   }
        // }
        
        // return flips;

        int flips = 0;
        Queue<Integer> q = new LinkedList();

        for(int i = 0; i < nums.length; i ++){
            if(!q.isEmpty() && q.peek() + k == i){
                q.poll();
            }

            if(q.size() % 2 == nums[i]){
                if(i + k > nums.length)return -1;

                flips ++;
                q.offer(i);
            }
        }

        return flips;

    }
}
