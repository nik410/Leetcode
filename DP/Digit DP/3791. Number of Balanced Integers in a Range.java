// Task: You are given two integers low and high.
// An integer is called balanced if it satisfies both of the following conditions:
//     It contains at least two digits.
//     The sum of digits at even positions is equal to the sum of digits at odd positions (the leftmost digit has position 1).
// Return an integer representing the number of balanced integers in the range [low, high] (both inclusive).

// Constraint: 1 <= low <= high <= 10^15

// Approach: Use digit dp as constraint very high.


class Solution {

    long count(String r, int digits, int constraint, int leadingZero, int leastTwoDig, int sumDiff, long dp[][][][][]){
        if(digits == 0){
            if(sumDiff == 0 && leastTwoDig >= 2){
                return 1;
            }
            return 0;
        }

        if(dp[digits][constraint][leadingZero][leastTwoDig][sumDiff + 19 * 7] != -1){
            return dp[digits][constraint][leadingZero][leastTwoDig][sumDiff + 19 * 7];
        }

        int limit = r.charAt(r.length() - digits) - '0';
        int validDigit = (constraint == 1) ? limit : 9;

        long ans = 0;

        for(int i = 0; i <= validDigit; i ++){

            int nextConstraint = (constraint == 1 && i == limit) ? 1 : 0;
            boolean isIndexEven = (digits % 2 == 0) ? true : false;
            int nextSumDiff = sumDiff;
            
            if(isIndexEven){
                nextSumDiff += i;
            }
            else{
                nextSumDiff -= i;
            }

            int nextLeadingZero = (leadingZero == 1 && i == 0) ? 1 : 0;

            int nextLeastTwoDig = leastTwoDig;
            if(nextLeadingZero == 0){
                nextLeastTwoDig += 1;
                if(nextLeastTwoDig >= 2){
                    nextLeastTwoDig = 2;
                }
            }

            ans += count(r, digits - 1, nextConstraint, nextLeadingZero, nextLeastTwoDig, nextSumDiff, dp);
        }

        return dp[digits][constraint][leadingZero][leastTwoDig][sumDiff + 19 * 7] = ans;
    }

    public long countBalanced(long low, long high) {
        String r = Long.toString(high);
        int len1 = r.length();

        long dp[][][][][] = new long[17][2][2][3][17 * 9 * 2 + 1];

        initializeDP(dp);
        
        long c1 = count(r, len1, 1, 1, 0, 0, dp);

        String l = Long.toString(low - 1);
        int len2 = l.length();

        initializeDP(dp);
        
        long c2 = count(l, len2, 1, 1, 0, 0, dp);

        return c1 - c2;
    }

    void initializeDP(long dp[][][][][]){
        
        for (long[][][][] d1 : dp) {
            for (long[][][] d2 : d1) {
                for (long[][] d3 : d2) {
                    for (long[] d4 : d3) {
                        Arrays.fill(d4, -1);
                    }
                }
            }
        }
   
    }
}
