class Solution {

    private HashMap<String, Integer> dp = new HashMap<>();     

    public int maxMoves(int grid[][], int colIndex, int rowIndex, int prevVal){
        int row = grid.length;
        int col = grid[0].length;

        if(colIndex == col){
            return 0;
        }
        String key = colIndex + "," + rowIndex + "," + prevVal;
        
        
        if (dp.containsKey(key)) {
            return dp.get(key);
        }


        int ans = 0;


        if(colIndex  + 1 < col &&  rowIndex - 1 >= 0 && grid[rowIndex - 1][colIndex + 1] > prevVal){
            ans = Math.max(ans, 1  + maxMoves(grid, colIndex + 1, rowIndex  - 1, grid[rowIndex - 1][colIndex + 1]));
        }

        if(colIndex  + 1 < col  && grid[rowIndex][colIndex + 1] >  prevVal ){
            ans = Math.max(ans, 1  + maxMoves(grid, colIndex + 1, rowIndex, grid[rowIndex][colIndex + 1]));
        }

        if(colIndex + 1 < col &&  rowIndex + 1 < row && grid[rowIndex + 1][colIndex + 1] > prevVal ){
            ans = Math.max(ans, 1  + maxMoves(grid, colIndex + 1, rowIndex  + 1, grid[rowIndex + 1][colIndex + 1]));
        }

        // for(int i = 0 ; i < grid[0].length; i ++){
        //     if(grid[rowIndex][i] > prevVal){
        //         ans = Math.max(ans, 1 + maxMoves(grid, i, rowIndex + 1, grid[rowIndex][i]));
        //     }
        // }
        dp.put(key, ans);
        return ans;

    }

    public int maxMoves(int[][] grid) {
        int ans = 0;

        for(int i = 0; i < grid.length; i ++){
            ans = Math.max(ans, maxMoves(grid, 0, i, grid[i][0]));
        }

        return ans;
    }
}
