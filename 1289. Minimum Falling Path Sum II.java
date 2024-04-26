class Solution {

    public int solve(int grid[][], int i, int notJ, int dp[][]){
        if(i == grid.length)return 0;

        if(dp[i][notJ] != -1)return dp[i][notJ];
        int ans = Integer.MAX_VALUE;

        for(int in = 0; in < grid[0].length; in++){
            if(in == notJ)continue;

            ans = Math.min(ans, grid[i][in] + solve(grid, i + 1, in, dp));
        }

        return dp[i][notJ] = ans;
    }

    public int minFallingPathSum(int[][] grid) {
        
        int ansMin = Integer.MAX_VALUE;
        int dp[][] = new int[grid.length + 1][grid[0].length];

        for(int i = 0; i < grid.length + 1; i++){
            Arrays.fill(dp[i], -1);
        }

        for(int i = 0; i < grid[0].length; i++){
            ansMin = Math.min(ansMin, grid[0][i] + solve(grid, 1, i, dp));
        }
        
        return ansMin;
    }
}
