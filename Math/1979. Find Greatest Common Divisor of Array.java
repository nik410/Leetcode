// Task : Given an integer array nums, return the greatest common divisor of the smallest number and largest number in nums.
//       The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.
// Constraint :
//     2 <= nums.length <= 1000
//     1 <= nums[i] <= 1000

// Approach : FInd max and min element in one loop and then use euclidean GCD.

// Time and Space Complexity : TC : O(n + log(max(a, n)) SC: O(1)

  class Solution {
    public int findGCD(int[] nums) {
        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;

        for(int i: nums){
            smallest = Math.min(smallest, i);
            largest = Math.max(largest, i);
        }

        return gcd(smallest, largest);
    }

    int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}
