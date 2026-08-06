// Task: You are given two integers n and t. Return the smallest number greater than or equal to n such that the product of its digits is divisible by t.

// Constraint: 1 <= n <= 100
//             1 <= t <= 10

// Approach: As the constraint are very small. The bruteforce of running a loop works. But it will require digit DP for larger contrainst.

// Time and Space Complexity:
//   TC : O( logn * 1)
//   SC : O(1)


class Solution {
    public int smallestNumber(int n, int t) {
        for(int i = n; i <= 100; i ++){
            
            int digitProduct = 1;
            int num = i;

            while(num > 0){
                int digit = num % 10;
                digitProduct *= digit;
                num /= 10;
            }

            if(digitProduct % t == 0){
                return i;
            }
        }
        
        return -1;
    }
}
  


