// Task: Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.
//       Return the number of closed islands.

// Constraint: 1 <= grid.length, grid[0].length <= 100
//             0 <= grid[i][j] <=1

// Approach: Use BFS or DFS. Key point if any node with 0 value touches the boundary then its not a valid island.

// Time and Space Complexity: 
        // TC: O(m * n) 
        // SC: O(n*m) 
        // where n = grid.length and m = grid[0].length

class Solution {
    
    public int bfs(int x, int y, int visited[][], int grid[][]){
        Queue<int[]> q = new LinkedList();

        int isIsland = 1;

        q.offer(new int[]{x, y});
        visited[x][y] = 1;

        if(x == 0 || y == 0 || x == grid.length - 1  || y == grid[0].length - 1){
            isIsland = -1;
        }

        int dir[][] = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
        };

        // If at any point a node of the island is touching with the boundary
        // That is not a valid island right??

        while(!q.isEmpty()){
            int node[] = q.poll();

            for(int d[]: dir){
                int newX = d[0] + node[0];
                int newY = d[1] + node[1];

                if(newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length &&
                    grid[newX][newY] == 0 && visited[newX][newY] == 0){
                    
                    q.offer(new int[]{newX, newY});
                    visited[newX][newY] = 1;
                    
                    if(newX == 0 || newY == 0 || newX == grid.length - 1  || newY == grid[0].length - 1){
                        isIsland = -1;
                    }
                }
            }
        }

        return(isIsland == 1) ? 1 : 0;
    }

    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int visited[][] = new int[n][m];

        int islandCount = 0;

        for(int i = 0; i < n; i ++){
            for(int j = 0; j < m; j ++){
                if(grid[i][j] == 0 && visited[i][j] == 0){
                    islandCount += bfs(i, j, visited, grid);
                }
            }
        }

        return islandCount;
    }
}
