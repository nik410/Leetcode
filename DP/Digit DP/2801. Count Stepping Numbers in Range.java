// Task: Given two positive integers low and high represented as strings, find the count of stepping numbers in the inclusive range [low, high].
// A stepping number is an integer such that all of its adjacent digits have an absolute difference of exactly 1.
// Return an integer denoting the count of stepping numbers in the inclusive range [low, high].
// Since the answer may be very large, return it modulo 109 + 7.
// Note: A stepping number should not have a leading zero.

// Constraint: 
//     1 <= int(low) <= int(high) < 10100
//     1 <= low.length, high.length <= 100
//     low and high consist of only digits.
//     low and high don't have any leading zeros.

// Approach: Use digit DP as constraint is large


class Solution {
    
    int count(String r, int digitCount, int constrainst, int leadingZero, int prevDigit, int dp[][][][]){
        if(digitCount == 0){
            if(leadingZero == 0){
                return 1;
            }
            return 0;
        }

        if(dp[digitCount][constrainst][leadingZero][prevDigit] != -1){
            return dp[digitCount][constrainst][leadingZero][prevDigit];
        }

        int digit = r.charAt(r.length() - digitCount) - '0';
        int limit = (constrainst == 1) ? digit : 9;

        int ans = 0;

        for(int i = 0; i <= limit; i ++){

            int nextConstrainst = (constrainst == 1 && i == digit) ? 1 : 0;
            int nextLeadingZero = (leadingZero == 1 && i == 0) ? 1 : 0;

            int nextPrevDigit = prevDigit;

            if(nextLeadingZero == 0){
                if(leadingZero == 1){
                    nextPrevDigit = i;
                }
                else{
                    int abs = Math.abs(prevDigit - i);
                    if(abs == 1){
                        nextPrevDigit = i;
                    }
                    else{
                        continue;
                    }
                }
            }

            ans = (ans + count(r, digitCount - 1, nextConstrainst, nextLeadingZero, nextPrevDigit, dp)) % (int)(1e9 + 7);
        }

        return dp[digitCount][constrainst][leadingZero][prevDigit] = ans % (int)(1e9 + 7);
    }
    
    public int countSteppingNumbers(String low, String high) {
        int len1 = high.length();
        int len2 = low.length();

        int dp[][][][] = new int[103][2][2][13];

        initializeDP(dp);

        int count1 = count(high, len1, 1, 1, 12, dp);

        initializeDP(dp);
        int count2 = count(low, len2, 1, 1, 12, dp);


        int prev = -1;
        int isStep = 1;
        for(int i = 0; i < len2; i ++){
            int val = low.charAt(i) - '0';

            if(i == 0){
                prev = val;
            }
            else{
                if(Math.abs(prev - val) == 1){
                    prev = val;
                }
                else{
                    isStep = 0;
                    break;
                }
            }
        }
        

        int ans = (count1 - count2 + isStep + (int)(1e9 + 7)) % (int)(1e9 + 7);

        return ans;
    }

    void initializeDP(int dp[][][][]){
        for(int i = 0; i < dp.length; i ++){
            for(int j = 0; j < dp[0].length; j ++){
                for(int k = 0; k < dp[0][0].length; k ++){
                    for(int l = 0; l < dp[0][0][0].length; l ++){
                        dp[i][j][k][l] = -1;
                    }
                }
            }
        }
    }
}
