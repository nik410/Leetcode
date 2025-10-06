class Solution {

    class Pair{
        int x;
        int y;

        Pair(int x, int y){
            this.x = x;
            this.y = y; 
        }
    }

    public boolean minTime(int grid[][], int time){
        int row = grid.length;
        int col = grid[0].length;

        boolean visited[][] = new boolean[row][col];

        Queue<Pair> q = new LinkedList();

        if(grid[0][0] <= time){
            q.offer(new Pair(0, 0));
            visited[0][0] = true;
        }

        int direc[][] = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
        };

        while(!q.isEmpty()){
            Pair p = q.poll();

            if(p.x == row - 1 && p.y == col - 1)return true;

            for(int i[]: direc){
                int newX = p.x + i[0];
                int newY = p.y + i[1];

                if(newX >= 0 && newX < row && newY >= 0 && newY <col && visited[newX][newY] == false){
                    if(grid[newX][newY] <= time){
                        q.offer(new Pair(newX, newY));
                        visited[newX][newY] = true;
                    }
                    
                }
            }

        }

        return false;
        
    }

    public int swimInWater(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
        
        for(int i = 0; i < row; i ++){
            for(int j = 0; j < col; j ++){
                int val = grid[i][j];
                l = Math.min(l, val);
                r = Math.max(r, val);
            }
        }

        int ans = -1;

        while(l <= r){
            int mid = l + (r - l) / 2;
          
            if(minTime(grid, mid)){
                r = mid - 1;               
                ans = mid;
            }
            else{
                l = mid + 1;
            }

        }

        return ans;

    }
}
