// Task: You are given a positive integer n. Determine whether n is divisible by the sum of the following two values:
//           The digit sum of n (the sum of its digits).
//           The digit product of n (the product of its digits).
//       Return true if n is divisible by this sum; otherwise, return false.

// Constraint: 1 <= n <= 10e6

// Approach: Loop through the digits.

// Time and Space Complexity: 
//     TC: O(log10 n)
//     SC: O(1)


class Solution {
    public boolean checkDivisibility(int n) {
        int add = 0;
        int product = 1;

        int nCopy = n;

        while(nCopy > 0){
            int digit = nCopy % 10;

            add += digit;
            product *= digit;

            nCopy /= 10;
        }

        return (n % (add + product) == 0) ? true : false;
    }
}
