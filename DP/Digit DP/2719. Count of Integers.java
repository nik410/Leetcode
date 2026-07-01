// Task: You are given two numeric strings num1 and num2 and two integers max_sum and min_sum. We denote an integer x to be good if:
//     num1 <= x <= num2
//     min_sum <= digit_sum(x) <= max_sum.
// Return the number of good integers. Since the answer may be large, return it modulo 109 + 7.
// Note that digit_sum(x) denotes the sum of the digits of x.

// Constraint:
// 1 <= num1 <= num2 <= 1022
// 1 <= min_sum <= max_sum <= 400

// Approach: Use brute force first thought but as the constrainsts are huge it will not work. Use digit dp with tabulation

class Solution {

    int solve(String r, int digitCount, int sum, int constrainst,int min_sum, int max_sum, int dp[][][]){
        if(digitCount == 0){
            if(sum >= min_sum && sum <= max_sum){
                return 1;
            }
            return 0;
        }

        if(dp[digitCount][sum][constrainst] != -1)return dp[digitCount][sum][constrainst];

        int digit = r.charAt(r.length() - digitCount) - '0';
        int limit = (constrainst == 1) ? digit : 9;

        int ans = 0;
        for(int i = 0; i <= limit; i ++){

            int nextConstrainst = (constrainst == 1 && i == digit) ? 1 : 0;
            
            ans = (ans + solve(r, digitCount - 1, sum + i, nextConstrainst, min_sum, max_sum, dp)) % (int)(1e9 + 7);
        }

        return dp[digitCount][sum][constrainst] = ans;
    }

    public int count(String num1, String num2, int min_sum, int max_sum) {
        int len1 = num1.length();
        int len2 = num2.length();

        int maxLength = Math.max(len1, len2);

        int mod = (int)(1e9 + 7);

        int dp[][][] = new int[24][(maxLength + 1) * 9][2];

        initializeDP(dp);

        int c1 = solve(num1, len1, 0, 1, min_sum, max_sum, dp);

        // Reinitailize 
        
        initializeDP(dp);

        int c2 = solve(num2, len2, 0, 1, min_sum, max_sum, dp);

        int ans = (c2 - c1 + mod) % mod;

        int digitSum = 0;

        for(int i = 0; i < num1.length(); i ++){
            int val = Character.getNumericValue(num1.charAt(i));
            digitSum += val;
        }

        if(digitSum >= min_sum && digitSum <= max_sum){
            ans = (ans + 1) % mod;
        }

        return ans; 
    }

    void initializeDP(int dp[][][]){
        
        for(int i = 0; i < dp.length; i ++){
            for(int j = 0; j < dp[0].length; j ++){
                for(int k = 0; k < dp[0][0].length; k ++){
                    dp[i][j][k] = -1;
                }
            }
        }

        return;
    }
}
