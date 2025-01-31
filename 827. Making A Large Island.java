class Solution {

    public static int dfs(int grid[][], int i, int j, int id){
        if(i < 0 || i == grid.length || j < 0 || j >= grid.length || grid[i][j] != 1){
            return 0;
        }

        grid[i][j] = id;

        int count = 1;

        int direc[][] = {{-1, 0},
        {1, 0},
        {0, 1},
        {0, -1}};

        for(int d[]: direc){
            int newX = i + d[0];
            int newY = j + d[1];

            count += dfs(grid, newX, newY, id);
        }

        return count;
    }

    public int largestIsland(int[][] grid) {

        int maxArea = 0;
        int len = grid.length;

        int id = 2;

        HashMap<Integer, Integer> hm = new HashMap();

        for(int i = 0; i < len; i ++){
            for(int j = 0; j < len; j ++){
                if(grid[i][j] == 1){
                    int siz = dfs(grid, i, j, id);
                    maxArea = Math.max(siz, maxArea);
                    hm.put(id, siz);
                    id ++;
                }
            }
        }

        for(int i = 0; i < len; i ++){
            for(int j = 0; j < len; j ++){
                if(grid[i][j] == 0){
                    HashSet<Integer> hs = new HashSet();
                    int direc[][] = {{-1, 0},
                        {1, 0},
                        {0, 1},
                        {0, -1}};
                    for(int d[]: direc){
                        int newX = i + d[0];
                        int newY = j + d[1];

                        if(newX >= 0  && newX < len && newY >= 0 && newY < len && grid[newX][newY] != 0){
                            hs.add(grid[newX][newY]);
                        }
                    }
                    int sum = 1;
                    for(int idd: hs){
                        sum += hm.get(idd);
                    }

                    maxArea = Math.max(sum, maxArea);
                }
            }
        }

        return maxArea;
    }
}
