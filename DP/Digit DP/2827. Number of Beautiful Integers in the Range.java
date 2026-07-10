// Task: You are given positive integers low, high, and k.
// A number is beautiful if it meets both of the following conditions:
//     The count of even digits in the number is equal to the count of odd digits.
//     The number is divisible by k.
// Return the number of beautiful integers in the range [low, high].

// Constraint: 
//     0 < low <= high <= 109
//     0 < k <= 20

// Approach: Use digit DP as large contrainst. Brute force of running loop gives TLE.

class Solution {

    int count(String r, int dig, int constraint, int leadingZero, int odd, int even, int mod, int k, int dp[][][][][][]){
        if(dig == 0){
            if(leadingZero == 0 &&odd == even && mod % k == 0){
                return 1;
            }
            return 0;
        }

        if(dp[dig][constraint][leadingZero][odd][even][mod] != -1){
            return dp[dig][constraint][leadingZero][odd][even][mod];
        }

        int digitAtI = r.charAt(r.length() - dig) - '0';
        int limit = (constraint == 1) ? digitAtI : 9;

        int ans = 0;

        for(int i = 0; i <= limit; i ++){
            int nextConstraint = (constraint == 1 && i == digitAtI) ? 1 : 0;
            int nextLeadingZero = (leadingZero == 1 && i == 0) ? 1 : 0;


            int nextOdd = odd, nextEven = even, nextMod = mod; 
            if(nextLeadingZero == 0){
                if(i % 2 == 0){
                    nextEven += 1;
                }
                else{
                    nextOdd += 1;
                }

                nextMod = (mod * 10 + i) % k;
            }

            ans += count(r, dig - 1, nextConstraint, nextLeadingZero, nextOdd, nextEven, nextMod, k, dp);
        }

        return dp[dig][constraint][leadingZero][odd][even][mod] = ans;
    }

    public int numberOfBeautifulIntegers(int low, int high, int k) {
        String s1 = Integer.toString(high);
        String s2 = Integer.toString(low - 1);
        
        int len1 = s1.length();
        int len2 = s2.length();

        int dp[][][][][][] = new int[11][2][2][10][10][21];

        initializeDP(dp);

        int count1 = count(s1, len1, 1, 1, 0, 0, 0, k, dp);

        initializeDP(dp);

        int count2 = count(s2, len2, 1, 1, 0, 0, 0, k, dp);

        return count1 - count2;
    }

    void initializeDP(int dp[][][][][][]){
         for (int[][][][][] a : dp) {
            for (int[][][][] b : a) {
                for (int[][][] c : b) {
                    for (int[][] d : c) {
                        for (int[] e : d) {
                            Arrays.fill(e, -1);
                        }
                    }
                }
            }
        }
    }
}
