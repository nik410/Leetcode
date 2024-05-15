class Solution {
    
    class Pair{
        int x;
        int y;

        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }

    }

    boolean check(int[][] nearestThief, int mid){
        int move[][] = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}            
        };

        boolean visited[][] = new boolean[nearestThief.length][nearestThief[0].length];


        Queue<Pair> q = new LinkedList();
        q.add(new Pair(0, 0));
        visited[0][0] = true;

        if(mid > nearestThief[0][0])return false;

        while(!q.isEmpty()){
            int currx = q.peek().x;

            int curry = q.peek().y;
            q.poll();

            if(currx == nearestThief.length - 1 && curry == nearestThief[0].length - 1)return true;

            for(int[] m: move){
                int newx = currx + m[0];
                int newy = curry + m[1];

                    if(newx >= 0 && newx < nearestThief.length && newy >= 0 && newy < nearestThief[0].length &&
                       visited[newx][newy] != true){
                            
                            if(nearestThief[newx][newy] < mid)continue;

                            q.offer(new Pair(newx, newy));
                            visited[newx][newy] = true;
                    
                    }

                    
            }

        }

        return false;
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        Queue<Pair> q = new LinkedList();
        boolean visited[][] = new boolean[grid.size()][grid.get(0).size()];
        int nearestThief[][] = new int[grid.size()][grid.get(0).size()];
        for(int i = 0; i < grid.size(); i ++){
            for(int j = 0; j < grid.get(0).size(); j ++){

                if(grid.get(i).get(j) == 1){
                    q.add(new Pair(i, j));
                    visited[i][j] = true;

                }
            }
        }

         int[][] movements = {
            {-1, 0}, // Up
            {1, 0},  // Down
            {0, -1}, // Left
            {0, 1}   // Right
        };

       

       int level = 0;

       while(!q.isEmpty()){
            int siz = q.size();
            for(int i = 0; i < siz; i ++){
                int xAxis = q.peek().x;
                int yAxis = q.peek().y;
                q.poll();
                nearestThief[xAxis][yAxis] = level;
                 for (int[] move : movements) {
                    int newX = xAxis + move[0];
                    int newY = yAxis + move[1];
                    
                    if(newX < 0 || newX >= grid.size() || newY < 0 || newY >= grid.get(0).size() ||
                        visited[newX][newY] == true){
                            continue;
                        }

                    q.offer(new Pair(newX, newY));
                       
                    visited[newX][newY] = true;   
                    
                }

            }
            level++;
       }

       //The nearestThief 2D array contains the mini manhattan distance 

       int low = 0;
       int high = 400;
        int result = 0;
       while(low <= high){
        int mid = low + (high - low) / 2;

        if(check(nearestThief, mid)){
            result = mid;
            low = mid + 1;
        }
        else{
            high = mid - 1;            
        }
       }

       return result;

    }
}
