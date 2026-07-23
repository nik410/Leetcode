// Task:You are given an integer array nums of length n, where nums is a of the numbers in the range [1, n].
//       A XOR triplet is defined as the XOR of three elements nums[i] XOR nums[j] XOR nums[k] where i <= j <= k.
//       Return the number of unique XOR triplet values from all possible triplets (i, j, k).

// Constraint:1 <= n == nums.length <= 105
//            1 <= nums[i] <= n
//            nums is a permutation of integers from 1 to n.

// Approach: Use of bit manipulation. First instinct brute force using recursion but not possible due to size of n.

// Time and Space complexity:
//   TC: O(1)
//   SC: O(1)

class Solution {
    public int uniqueXorTriplets(int[] nums) {
        // By observation we can see that at minimum we will have nums.length unique values
        // As (n ^ n ^ n) = n similarly we can do for all the valuse for 1 to n
      
        int len = nums.length;

        if(len <= 2){
            return len;
        }

        int xorPossible = (int)(Math.log(len) / Math.log(2));

        return (int)Math.pow(2, xorPossible + 1);
    }
}
