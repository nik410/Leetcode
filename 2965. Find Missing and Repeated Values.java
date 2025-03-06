class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int len = grid.length;
        int totalEle = len * len;
        int totalSum = ((totalEle) * (totalEle + 1)) / 2;
        int ans[] = new int[2];

        int wrongSum = 0;

        outer: for(int i = 0; i < len; i ++){
                for(int j = 0; j < len; j ++){
                    wrongSum += Math.abs(grid[i][j]);

                    int val = Math.abs(grid[i][j]) - 1;

                    int row = val / len;
                    int col = val % len;                    

                    // System.out.println("i: " + i +  " j: " + j + " Row: " + row + " Col: " + col);
                   
                    if(grid[row][col] < 0){
                        // System.out.println("Row: " + row + " Col: " + col);
                        ans[0] = Math.abs(grid[i][j]); 
                        // break outer;                   
                    }else{
                        grid[row][col] *= -1;
                    }               
                }
            }

            System.out.println("TotalSum" + totalSum + " WrongSum: " + wrongSum + " ans[0]: " + ans[0]);

        if(totalSum < wrongSum)
            ans[1]= ans[0] - Math.abs(totalSum - wrongSum);
        else {
            ans[1] =  Math.abs(totalSum - wrongSum) + ans[0];
        }

        return ans;
    }
}
