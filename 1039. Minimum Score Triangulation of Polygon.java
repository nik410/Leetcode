class Solution {

    public int minScore(int values[], int i, int j, int dp[][]){

        if(j - i  + 1 < 3)return 0;

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int res = Integer.MAX_VALUE;
        for(int k = i + 1; k < j; k ++){
            int sc = minScore(values, i, k, dp) + (values[k] * values[i] * values[j]) + minScore(values, k, j, dp);

            res = Math.min(res, sc);
        }

        return dp[i][j] = res;
    }

    public int minScoreTriangulation(int[] values) {
        int len = values.length;
        int dp[][] = new int[len + 1][len + 1];

        for(int i[]: dp){
            Arrays.fill(i, -1);
        }

        return minScore(values, 0, values.length - 1, dp);
    }
}
