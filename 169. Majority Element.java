class Solution {
    public int majorityElement(int[] nums) {
       int count = 0;
       int candEle = nums[0];

       for(int i : nums){
           if(candEle == i){
               count++;
           }
           else if(count == 0){
               candEle = i;
               count = 1;
           }

           if(candEle != i)count --;
       }

       return candEle;

    }
}
