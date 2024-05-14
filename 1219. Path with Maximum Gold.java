class Solution {

   public int maxGold(int[][] grid, int i, int j, boolean[][] visited, int[][] dp) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }

        //if (dp[i][j] != 0) return dp[i][j];

        visited[i][j] = true;

        int left = grid[i][j] + maxGold(grid, i - 1, j, visited, dp);
        int right = grid[i][j] + maxGold(grid, i + 1, j, visited, dp);
        int top = grid[i][j] + maxGold(grid, i, j - 1, visited, dp);
        int bottom = grid[i][j] + maxGold(grid, i, j + 1, visited, dp);

        visited[i][j] = false;

        return dp[i][j] = Math.max(Math.max(left, right), Math.max(top, bottom));
    }

    public int getMaximumGold(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int[][] dp = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            Arrays.fill(dp[i], 0);
        }

        int maxGold = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] > 0) {
                    maxGold = Math.max(maxGold, maxGold(grid, i, j, visited, dp));
                }
            }
        }

        return maxGold;
    }
}
