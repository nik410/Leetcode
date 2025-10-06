class Solution {

    class Pair{
        int x;
        int y;

        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public List<Integer> isPossible(int heights[][], int i, int j){
        int row = heights.length;
        int col = heights[0].length;

        int atlantic = -1;
        int pacific = -1;


        List<Integer> al = new ArrayList();

        Queue<Pair> q = new LinkedList();

        q.offer(new Pair(i, j));

        int direc[][] = {
            {-1, 0},
            {1, 0},
            {0, 1},
            {0, - 1}
        };

        int visited[][] = new int[row][col];

        while(!q.isEmpty()){
            Pair p1 = q.poll();
             if(p1.x == 0 || p1.y == 0){
                pacific = 1;
            }

            if(p1.y == col - 1 || p1.x == row - 1){
                atlantic = 1;
            }

            if(atlantic == pacific && pacific == 1){
                al.add(i);
                al.add(j);
                return al;
            }

            for(int ind[]: direc){
                int newX = p1.x + ind[0];
                int newY = p1.y + ind[1];

                if(newX >= 0 && newX < row && newY >= 0 && newY < col && visited[newX][newY] == 0){
                    if(heights[newX][newY] <= heights[p1.x][p1.y]){
                        visited[newX][newY] = 1;
                        q.offer(new Pair(newX, newY));
                    }
                }
            }
        }

        return al;

    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        int row = heights.length;
        int col = heights[0].length;

        List<List<Integer>> ans = new ArrayList();

        for(int i = 0; i < row; i ++){
            for(int j = 0; j < col; j ++){
                List<Integer> al = isPossible(heights, i, j);

                if(al.size() > 0){
                    ans.add(new ArrayList(al));
                }
            }
        }

        return ans;

    }
}
