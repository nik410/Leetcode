// Task: Given an integer n, return the number of positive integers in the range [1, n] that have at least one repeated digit.

// Approach: Use digit dp with a bit mask for the the unique count.

class Solution {

    int count(String r, int digitCount, int constrainst, int containsRepeatDigit, int leadingZero,int mask, int dp[][][][][]){
        if(digitCount == 0){
            if(containsRepeatDigit == 1){
                return 1;
            }
            return 0;
        }

        if(dp[digitCount][constrainst][containsRepeatDigit][leadingZero][mask] != -1){
            return dp[digitCount][constrainst][containsRepeatDigit][leadingZero][mask];
        }
        

        int digitAtPos = r.charAt(r.length() - digitCount) - '0';

        int limit = (constrainst == 1) ? digitAtPos : 9;

        int ans = 0;

        for(int i = 0; i <= limit; i ++){
            
            int nextConstrainst = (constrainst == 1 && i == digitAtPos) ? 1 : 0;
            int nextContainsRepeatDigit = containsRepeatDigit;

            int nextLeadingZero = (i == 0 && leadingZero == 1) ? 1 : 0;

            int nextMask = mask;

             if(nextLeadingZero == 0){
                if ((mask & (1 << i)) != 0) {
                    nextContainsRepeatDigit = 1;
                }
               
                nextMask = (mask | (1 << i));
            }

            ans += count(r, digitCount - 1, nextConstrainst, nextContainsRepeatDigit, nextLeadingZero, nextMask, dp);
        }

        return dp[digitCount][constrainst][containsRepeatDigit][leadingZero][mask] = ans;
    }

    public int numDupDigitsAtMostN(int n) {
        String r = Integer.toString(n);
        int digitCount = r.length();

        int count[] = new int[10];
        int mask = 0;

        int dp[][][][][] = new int[11][2][2][2][1024];

        for(int i = 0; i < 11; i ++){
            for(int j = 0; j < 2; j ++){
                for(int k = 0; k < 2; k ++){
                    for(int l = 0; l < 2; l ++){
                        for(int m = 0; m < 1024; m ++){
                            dp[i][j][k][l][m] = -1;
                        }
                    }
                }
            }
        }

        return count(r, digitCount, 1, 0, 1, mask, dp);


    }
}
