// Task: You are given a positive integer n.
// For every integer x from 1 to n, we write down the integer obtained by removing all zeros from the decimal representation of x.
// Return an integer denoting the number of distinct integers written down.

// Constraint: 1 <= n <= 1015

// Approach: Use digit dp as constraint is huge

class Solution {

    long count(String r, int digitCount, int constrainst, int leadingZero, long dp[][][]){
        if(digitCount == 0){
            if(leadingZero == 0)return 1;
            return 0;
        }

        if(dp[digitCount][constrainst][leadingZero] != -1)return dp[digitCount][constrainst][leadingZero];

        int digit = r.charAt(r.length() - digitCount) - '0';
        int limit = (constrainst == 1) ? digit : 9;

        long ans = 0;

        for(int i = 0; i <= limit; i ++){
            
            if(leadingZero == 0){
                if(i == 0)continue;
            }

            ans += count(r, digitCount - 1, (constrainst == 1 && i == digit) ? 1 : 0, (leadingZero == 1 && i == 0) ? 1 : 0, dp);
        }

        return dp[digitCount][constrainst][leadingZero] = ans;
    }

    public long countDistinct(long n) {
        String r = Long.toString(n);
        int len = r.length();

        long dp[][][] = new long[17][2][2];

        for(int i = 0; i < dp.length; i ++){
            for(int j = 0; j < 2; j ++){
                for(int k = 0; k < 2; k ++){
                    dp[i][j][k] = -1;
                }
            }
        }

        return count(r, len, 1, 1, dp);    
    }
}
