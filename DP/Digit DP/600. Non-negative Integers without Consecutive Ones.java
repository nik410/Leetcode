// Tas k: Given a positive integer n, return the number of the integers in the range [0, n] whose binary representations do not contain consecutive ones.

// Constraint : 1 <= n <= 109

// Approach : Use digit dp as brute force of runnign a loop across the range is Time Limit Exceeded.

// Time and Space Complexity: 
//   TC : O( B * 2 * 2) where B is bits ~ O(128)
//   SC : O(32 * 2 * 2) for the dp / memoization table

class Solution {

    int count(int n, int digits, int prevBit, int constraint, int dp[][][]){
        if(digits < 0){
            return 1;
        }

        if(dp[digits][prevBit][constraint] != - 1)return dp[digits][prevBit][constraint];

        int bitAtDig = (1 & (n >> digits));
        int limit = (constraint == 1) ? bitAtDig : 1;

        int ans = 0;

        for(int i = 0; i <= limit; i ++){
            if(prevBit == 1 && i == 1)continue;

            int nextPrevBit = i;
            int nextConstraint = (constraint == 1 && i == bitAtDig) ? 1 : 0;

            ans += count(n, digits - 1, nextPrevBit, nextConstraint, dp);
        }

        return dp[digits][prevBit][constraint] = ans;
    }

    public int findIntegers(int n) {
        int dp[][][] = new int[32][2][2];

        for(int i = 0; i < dp.length; i ++){
            for(int j = 0; j < dp[0].length; j ++){
                for(int k = 0; k < dp[0][0].length; k ++){
                    dp[i][j][k] = -1;
                }
            }
        }

        return count(n, 31, 0, 1, dp);
    }
}
