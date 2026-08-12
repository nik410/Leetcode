// Task: You are given an integer array nums and an integer k.
//       The frequency of an element x is the number of times it occurs in an array.
//       An array is called good if the frequency of each element in this array is less than or equal to k.
//       Return the length of the longest good subarray of nums.
//       A subarray is a contiguous non-empty sequence of elements within an array.

// Constraint: 1 <= nums.length <= 105
//             1 <= nums[i] <= 109
//             1 <= k <= nums.length

// Approach: Brute force with two for loop. Optimal to use two pointer with a hashmap. Can use a freq array but nums[i] is a very large value.

// Time and Space Complexity:
//   TC: O(n)
//   SC: O(1)

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int len = nums.length;

        HashMap<Integer, Integer> hm = new HashMap();

        int l = 0, r = 0;

        int maxSub = 0;

        while(r < len){
            int val = nums[r];
            hm.put(val, hm.getOrDefault(val, 0) + 1);

            while(hm.get(val) > k && l < r){
                int valAtLIndex = nums[l];

                hm.put(valAtLIndex, hm.getOrDefault(valAtLIndex, 0) - 1);
                l ++;
            }

            maxSub = Math.max(maxSub, r - l + 1);
            r ++;
        }

        return maxSub;
    }
}

  
