// Task:You are given an m x n binary matrix grid and an integer health.
// You start on the upper-left corner (0, 0) and would like to get to the lower-right corner (m - 1, n - 1).
// You can move up, down, left, or right from one cell to another adjacent cell as long as your health remains positive.
// Cells (i, j) with grid[i][j] = 1 are considered unsafe and reduce your health by 1.
// Return true if you can reach the final cell with a health value of 1 or more, and false otherwise.


// Approach: use BFS but a little inefficent. use of Djikstra is optimal [To Do]

class Solution {

    class Data{
        int x;
        int y;
        int health;

        Data(int x, int y, int health){
            this.x = x;
            this.y = y;
            this.health = health;
        }
    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int row = grid.size();
        int col = grid.get(0).size();
        int maxHealth[][] = new int[row][col];

        for(int i[]: maxHealth){
            Arrays.fill(i, -1);
        }

        Queue<Data> q = new LinkedList();

        int startingHealth = health - (grid.get(0).get(0));

        q.offer(new Data(0, 0, startingHealth));
        maxHealth[0][0] = startingHealth;

        int direc[][] = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
        };

        while(!q.isEmpty()){
        
            int size = q.size();

            for(int  i= 0; i < size; i ++){
                Data d = q.poll();

                if(d.x == row - 1 && d.y == col - 1 && d.health >= 1){
                    return true;
                }

                for(int dir[]: direc){
                    int newX = d.x + dir[0];
                    int newY = d.y + dir[1];

                    int gridVal = 0;
                    if(newX >= 0 && newX < row && newY >=0 && newY < col){
                        gridVal = grid.get(newX).get(newY);
                    }

                    int newHealth = d.health - gridVal;

                    if(newX >= 0 && newX < row && newY >=0 && newY < col && newHealth > 0 && newHealth > maxHealth[newX][newY]){
                        q.offer(new Data(newX, newY, newHealth));
                        maxHealth[newX][newY] = newHealth;
                    }
                }
            }
        }

        return false;
    }
}
