// Task: Given two strings s and t, return the number of distinct subsequences of s which equals t.
//       The test cases are generated so that the answer fits on a 32-bit signed integer.

// Constraint: 1 <= s.length, t.length <= 1000
//             s and t consist of English letters.

// Approach: Use of dp with pick not pick variant [ Can in one way be called a variant Knapsack]

// Time and Space Complexity: 
//   TC: O(n^2)
//   SC: O(n^2)

class Solution {

    public int disSub(String s, String t, int i, int j, int dp[][]){
        if(j == t.length()){
            return 1;
        }

        if(i == s.length()){
            return 0;
        }

        if(dp[i][j] != -1)return dp[i][j];

        int take = 0;
        int notTake = 0;
        if(s.charAt(i) == t.charAt(j)){
            take = disSub(s, t, i + 1, j + 1, dp);
            notTake = disSub(s, t, i + 1, j, dp);
        }
        else{
            notTake = disSub(s, t, i + 1, j, dp);
        }

        return dp[i][j] = take + notTake;
    }

    public int numDistinct(String s, String t) {

        int dp[][] = new int[s.length()][t.length()];

        for(int i[]: dp){
            Arrays.fill(i, -1);
        }
        return disSub(s, t, 0, 0, dp);
    }
}
