// Task: You are given an integer array nums of length n.
//       Construct an array prefixGcd where for each index i:
//           Let mxi = max(nums[0], nums[1], ..., nums[i]).
//           prefixGcd[i] = gcd(nums[i], mxi).
//       After constructing prefixGcd:
//           Sort prefixGcd in non-decreasing order.
//           Form pairs by taking the smallest unpaired element and the largest unpaired element.
//           Repeat this process until no more pairs can be formed.
//           For each formed pair, compute the gcd of the two elements.
//           If n is odd, the middle element in the prefixGcd array remains unpaired and should be ignored.
//       Return an integer denoting the sum of the GCD values of all formed pairs.
//       The term gcd(a, b) denotes the greatest common divisor of a and b. 


// Constraint:
//     1 <= n == nums.length <= 105
//     1 <= nums[i] <= 10​​​​​​​9


// Approach: Use sorting and prefix array to maintain the prefGcd for later use. Use Euclid Gcd approach for faster GCD calculation.

// Time and Space Complexity: 
//   TC: O(n * logn)
//   SC: O(n)



  class Solution {
    public long gcdSum(int[] nums) {
        int len = nums.length;

        int prefGcd[] = new int[len];
        int maxVal = nums[0];

        for(int i = 0; i < len; i ++){
            int val = nums[i];

            maxVal = Math.max(val, maxVal);

            prefGcd[i] = gcd(val, maxVal);
        }

        Arrays.sort(prefGcd);

        long ans = 0;

        for(int i = 0; i < len / 2; i ++){
            int val1 = prefGcd[i];
            int val2 = prefGcd[len - 1 - i];

            ans += gcd(val1, val2) + 0L;
        }

        return ans;
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
