// Task: Given an array of digits which is sorted in non-decreasing order. You can write numbers using each digits[i] as many times as we want. For example, if digits = ['1','3','5'], we may write numbers such as '13', '551', and '1351315'.
//       Return the number of positive integers that can be generated that are less than or equal to a given integer n.

// Approach: Use brute force, math and combinatorics. Use digit DP with combinatorics.

class Solution {

    int count(String r, int countDig, String[] digits, int constrainst, int dp[][]){
        if(countDig == 0){
            return 1;
        }

        if(dp[countDig][constrainst] != -1)return dp[countDig][constrainst];

        int ans = 0;

        int validDigit = r.charAt(r.length() - countDig) - '0';

        for(int i = 0; i < digits.length; i ++){
            int currVal = digits[i].charAt(0) - '0';

            if(constrainst == 1 && currVal > validDigit){
                continue;
            }

            ans += count(r, countDig - 1, digits, (((constrainst == 1)  && (currVal ==
            validDigit)) ? 1 : 0), dp);
        }

        return dp[countDig][constrainst] =  ans;
    }

    public int atMostNGivenDigitSet(String[] digits, int n) {
        String r = Integer.toString(n);
        int countDigit = r.length();

        int len = digits.length;

        int ans = 0;

        for(int i = 1; i < countDigit; i ++){
            ans += Math.pow(len, i);
        }

        int dp[][] = new int[11][2];

        for(int i[]: dp){
            Arrays.fill(i, -1);
        }

        ans += count(r, countDigit, digits, 1, dp);

        return ans;
    }
}
