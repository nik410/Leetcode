class Solution {

    long mod = (long) (1e9 + 7);
     long cache[][][];
    public long findPat(int m, int n, int maxMove, int startRow, int startColumn){
        if(startRow == m|| startRow < 0 || startColumn == n || startColumn < 0)return 1;

        if(maxMove == 0)return 0;

        if(cache[startRow][startColumn][maxMove] != -1) return cache[startRow][startColumn][maxMove];
        long res =0;
        res += findPat(m, n, maxMove - 1, startRow - 1, startColumn);

        res += findPat(m, n, maxMove - 1, startRow + 1, startColumn);

        res += findPat(m, n, maxMove - 1, startRow , startColumn + 1);

        res += findPat(m, n, maxMove - 1, startRow , startColumn - 1);


        return cache[startRow][startColumn][maxMove] = (res)% mod;
    }


    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        cache = new long[m + 1][n + 1][maxMove + 1];

        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++ ){
                Arrays.fill(cache[i][j], -1);
            }
        }
        return (int)findPat(m, n, maxMove, startRow, startColumn);
    }
}
