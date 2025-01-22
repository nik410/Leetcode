class Solution {

    class Pair{
        int i;
        int j;
        int height;

        Pair(int i, int j, int height){
            this.i = i;
            this.j = j;
            this.height = height;
        }
    }
    public int[][] highestPeak(int[][] isWater) {
        // MultiSource BFS
      
        Queue<Pair> q = new LinkedList();

        int row = isWater.length;
        int col = isWater[0].length;

        int visited[][] = new int[row][col];
        int height[][] = new int[row][col];

        for(int i = 0; i < row; i ++){
            for(int j = 0; j < col; j ++){
                
                if(isWater[i][j] == 1){
                    q.offer(new Pair(i, j, 0));
                    visited[i][j] = 1;
                    height[i][j] = 0;
                }
            }
        }

        int direc[][] = {{-1, 0},
        {1, 0},
        {0, 1},
        {0, -1}};

      

        while(!q.isEmpty()){
            int siz = q.size();

            for(int i = 0; i < siz; i ++){
                Pair p = q.poll();

                for(int d[]: direc){
                    int newX = p.i + d[0];
                    int newY = p.j + d[1];

                    if(newX >= 0 && newY >= 0 && newX < row && newY < col && visited[newX][newY] == 0){
                        q.offer(new Pair(newX, newY, p.height + 1));
                        
                        height[newX][newY] = p.height + 1;
                        visited[newX][newY] = 1;
                                                                      
                    }
                }
            }
        }        

        return height;
    }
}
