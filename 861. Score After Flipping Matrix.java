class Solution {
    public int matrixScore(int[][] grid) {
        
        int ans = grid.length * (int) (Math.pow(2, grid[0].length - 1));

        for(int i = 1; i < grid[0].length; i ++){
            int countOne = 0;
            int countZero = 0;
            for(int j = 0; j < grid.length; j ++){
                if(grid[j][0] == 0){
                    if(grid[j][i] == 0){
                        countOne++;
                    }
                    else countZero++;
                }

                 if(grid[j][0] == 1){
                    if(grid[j][i] == 1){
                        countOne++;
                    }
                    else countZero++;
                }
            }

            if(countZero > countOne){
                 ans += countZero * (int) (Math.pow(2, grid[0].length - i - 1));
            }
            else
            ans += countOne * (int) (Math.pow(2, grid[0].length - i - 1));
            // System.out.println("Col: " + i +" count1: " +  countOne +" Ans: " + ans);
        }

        return ans;
    }
}
