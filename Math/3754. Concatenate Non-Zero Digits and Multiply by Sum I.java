// Task: You are given an integer n.
// Form a new integer x by concatenating all the non-zero digits of n in their original order. If there are no non-zero digits, x = 0.
// Let sum be the sum of digits in x.
// Return an integer representing the value of x * sum.

// Constraint: 0 <= n < 1e9

// Approach: Convert Integer to string and find the concate and then find summation of digit. Use maths approach of using modulo and divison for final answer building.

class Solution {
    public long sumAndMultiply(int n) {
        long ans = 0;
        
        int nCopy = n;
        int step = 0;
        int sum = 0;

        while(nCopy > 0){
            int dig = nCopy % 10;
            
          if(dig != 0){
                ans += Math.pow(10, step) * dig;
                step ++;
            }
          
            sum += dig;
            nCopy /= 10;
            
        }

        ans *= sum;

        return ans;

    }
}
