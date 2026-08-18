Task: You are given an integer array nums and an integer k.
      An integer x is almost missing from nums if x appears in exactly one subarray of size k within nums.
      Return the largest almost missing integer from nums. If no such integer exists, return -1.
      A subarray is a contiguous sequence of elements within an array. 
Constraint: 1 <= nums.length <= 50
            0 <= nums[i] <= 50
            1 <= k <= nums.length

Approach: Observation based. First thought was to use the sliding window but that is O(n^2). 

Time and Space Complexity:
  TC: O(n)
  SC: O(n)


  class Solution {
      public int largestInteger(int[] nums, int k) {
          int len = nums.length;

          // If we observe we can make out that we only need to look at first k and last k
          // as middle one elements are almost guaranted to be in mutiple window if n - k + 1 > 0 

          // And also the number needs to be distinct
          // Upon further code run you can see only two contender for answer are there when k > 1 && k < len

          // for k == 1 and k == len they are edge cases and need to be handled seperately.
          // for k == 1 case the num needs to a unique that is freq = 1
          // for k == len we can select the maxEle in array as there can be only one subarray.

          int maxEle = -1;
          HashMap<Integer, Integer> hm = new HashMap();

          for(int i: nums){
              maxEle = Math.max(maxEle, i);
              hm.put(i, hm.getOrDefault(i, 0) + 1);
          }

          if(k == len){
              return maxEle;
          }

          if(k == 1){
               int maxUniq = -1;

              for(int i: hm.keySet()){
                  if(hm.get(i) == 1){
                      maxUniq = Math.max(maxUniq, i);
                  }
              }

              return maxUniq;
          }

          int largest = -1;

          int contender1 = nums[0];
         
          if(hm.get(contender1) == 1){
              largest = Math.max(largest, contender1);
          }

          int contender2 = nums[len - 1];
      
          if(hm.get(contender2) == 1){
              largest = Math.max(largest, contender2);
          }

          return largest;
      }
  }
