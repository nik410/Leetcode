// Task: You are climbing a staircase with n + 1 steps, numbered from 0 to n.
//       You are also given a 1-indexed integer array costs of length n, where costs[i] is the cost of step i.
//       From step i, you can jump only to step i + 1, i + 2, or i + 3. The cost of jumping from step i to step j is defined as: costs[j] + (j - i)2
//       You start from step 0 with cost = 0.
//       Return the minimum total cost to reach step n.

// Constraint: 1 <= n == costs.length <= 105​​​​​​​
//             1 <= costs[i] <= 104

// Approach:  A specific state is dependent on the previous state. Classic 1D dymaic programming task.

// Time and Space Complexity: 
//   TC: O(n)
//   SC: O(n)

class Solution {
    public int climbStairs(int n, int[] costs) {
        int len = costs.length;

        int dp[] = new int[len + 1];

        dp[0] = 0;
        dp[1] = costs[0] + 1;

        for(int i = 2; i <= len; i ++){
            int cost = Integer.MAX_VALUE;
            
            for(int j = Math.max(0, i - 3); j < i; j ++){

                int pathCost = costs[i - 1] + ((j - i) * (j - i));

                cost = Math.min(cost, dp[j] +  + pathCost);

                // System.out.println("Index: " + i + " Step: " + j + " path: " + (dp[j] + pathCost));
            }

            dp[i] = cost;

        }

        return dp[n];
    }
}
