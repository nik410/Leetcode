class Solution {

    class Pair{
        int row;
        int col;

        Pair(int row, int col){
            this.row = row;
            this.col = col;
        } 
    }

    public int bfs(int grid[][], int i, int j, boolean visited[][]){
        int sum = grid[i][j];

        int direc[][] = {{0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}};

        Queue<Pair> q= new LinkedList();

        visited[i][j] = true;
        
        q.offer(new Pair(i,j));

        while(!q.isEmpty()){
            int siz = q.size();

            for(int in = 0; in < siz; in ++){
                Pair p = q.poll();

                for(int d[]: direc){
                    int newX = p.row + d[0];
                    int newY = p.col + d[1];

                    if(newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length
                        && visited[newX][newY] == false && grid[newX][newY] > 0){
                            sum += grid[newX][newY];
                            q.offer(new Pair(newX, newY));
                            visited[newX][newY] = true;
                    }
                }
            }
        }

        return sum;
        
    }


    public int dfs(int grid[][], int i, int j, boolean visited[][]){
        visited[i][j] = true;
        int sum  = 0;

        int direc[][] = {{0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}};

        for(int d[]: direc){
            int newX = i + d[0];
            int newY = j + d[1];

            if(newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length){
                if(visited[newX][newY] == false && grid[newX][newY] > 0){
                    visited[newX][newY] = true;
                    sum += grid[newX][newY] +  dfs(grid, newX, newY, visited);
                }                
            }
        }

        return sum;
    }

    public int findMaxFish(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean visited[][] = new boolean[row][col];

        int maxFish = 0;

        for(int i = 0; i < row; i ++){
            for(int j = 0; j < col; j ++){
                if(grid[i][j] > 0){
                    maxFish = Math.max(maxFish, grid[i][j] + dfs(grid, i, j, visited));
                }
            }
        }

        return maxFish;

    }
}
