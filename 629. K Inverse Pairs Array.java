class Solution {
    public int kInversePairs(int n, int k) {
        int dp[][] = new int[n + 1][k + 1];
        
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= k; j++){
                if(j == 0)dp[i][j] = 1;
                else{
                for(int l = 0; l <= Math.min(i - 1, j); l++){
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - l]) % (int)(1e9 + 7);
                }
                }
            }
        }

        return dp[n][k];
    }
}
