class Solution {

    public int rec(int index, int n, int copy, int dp[][]){
        if(index > n){
            return (int)(1e9);
        }

        else if(index == n){
            return 0;
        }

        if(dp[index][copy] != 0)return dp[index][copy];

        int copyAll = 2 + rec(index + index, n, index, dp);
        int paste = 1 + rec(index + copy, n, copy, dp);

        return dp[index][copy] = Math.min(copyAll, paste);
    }

    public int minSteps(int n) {

        if(n == 1)return 0;

        int dp[][] = new int[n + 1][n + 1];

       return rec(1, n, 1, dp) + 1;
    }
}
