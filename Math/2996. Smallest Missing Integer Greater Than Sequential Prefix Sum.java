// Task: You are given a 0-indexed array of integers nums.
//       A prefix nums[0..i] is sequential if, for all 1 <= j <= i, nums[j] = nums[j - 1] + 1. In particular, the prefix consisting only of nums[0] is sequential.
//       Return the smallest integer x missing from nums such that x is greater than or equal to the sum of the longest sequential prefix.

// Constraint: 1 <= nums.length <= 50
//             1 <= nums[i] <= 50

// Approach: Use natural number summation . One quicl formulae for sum of numer between l to r range is ((l + r) * n)/ 2 where n is the number of elements
//           . Basically (r - l + 1) the gap between the range

// Time and Space Complexity:
//     TC: O(n)
//     SC: O(n)

class Solution {
    public int missingInteger(int[] nums) {
        int len = nums.length;
        int maxSequentialLength = 1;
        int term = nums[0];
        int present[] = new int[(50*49) / 2];

        for(int i: nums){
            present[i] = 1;
        }

        for(int i = 1; i < len; i ++){
           
            if(nums[i] - 1 == nums[i - 1]){
                term = nums[i];
                maxSequentialLength ++;
            }
            else {
                break;
            }
        }

        int l = term - (maxSequentialLength - 1);
        int r = term;

        int sum = ((l + r) * maxSequentialLength)  / 2;  

        // System.out.println("Sum: " + sum  + " seq: " + maxSequentialLength + " l : " + l + " r: " + r + " term: " + term);

        while(sum < present.length && present[sum] == 1){
            sum ++;
        }

        return sum;

    }
}
