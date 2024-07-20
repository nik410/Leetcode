class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int r = rowSum.length;
        int c = colSum.length;
        int ans[][] = new int[r][c];

        int pR = 0, pC = 0;

        while(pR < r && pC < c){
            int val = Math.min(rowSum[pR], colSum[pC]);

            rowSum[pR] -= val;
            colSum[pC] -= val;

            ans[pR][pC] = val;

            if(rowSum[pR] == 0){
                pR ++;
            }
            else {
                pC ++;
            }

        }
        return ans;
    }
}
