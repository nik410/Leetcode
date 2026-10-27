// Task: You are given an m x n matrix grid and a positive integer k. An island is a group of positive integers (representing land) that are 4-directionally connected (horizontally or vertically).
//       The total value of an island is the sum of the values of all cells in the island.
//       Return the number of islands with a total value divisible by k.

// Constraint: m == grid.length
//             n == grid[i].length
//             1 <= m, n <= 1000
//             1 <= m * n <= 105
//             0 <= grid[i][j] <= 106
//             1 <= k <= 106

// Approach: Use BFS or DFS. Islands are only on connecting +ve values.

// Time and Space Complexity: 
//   TC: O(m* n)
//   SC: O(m * n)
//   where n = grid.length and m = grid[0].length

class Solution {

    public long dfs(int x, int y, int grid[][], int visited[][]){
        visited[x][y] = 1;
        int dir[][] = {
            {-1, 0},
            {0, -1},
            {0, 1},
            {1, 0},
        };

        long sum = grid[x][y];

        for(int d[]: dir){
            int newX = d[0] + x;
            int newY = d[1] + y;

            if(newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length 
                && grid[newX][newY] > 0 && visited[newX][newY] == 0){
                    sum += dfs(newX, newY, grid, visited);
                }
        }

        return sum;



    }

    public int countIslands(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int visited[][] = new int[n][m];

        int islandCount = 0;

        for(int i = 0; i < n; i ++){
            for(int j = 0; j < m; j ++){
                if(grid[i][j] > 0 && visited[i][j] == 0){
                    long sum = dfs(i, j, grid, visited);
                    if(sum % (long)k == 0){
                        islandCount ++;
                    }
                }
            }
        }

        return islandCount;
    }
}
