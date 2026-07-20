// Task: Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.
      // In one shift operation:
      //     Element at grid[i][j] moves to grid[i][j + 1].
      //     Element at grid[i][n - 1] moves to grid[i + 1][0].
      //     Element at grid[m - 1][n - 1] moves to grid[0][0].
      // Return the 2D grid after applying shift operation k times.

// Constraint : 
//     m == grid.length
//     n == grid[i].length
//     1 <= m <= 50
//     1 <= n <= 50
//     -1000 <= grid[i][j] <= 1000
//     0 <= k <= 100

// Approach : First thought to do simulation upon further observation noticed the pattern.

// Time and Space complexity : 
//       TC : O(row * col) 
//       SC : O(row * col)

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;

        int modK = k % (col * row);

        // Upon careful observation we can see a pattern where we see each element moving to 
        // its right if no right then to the new row first element and if no new row then to the 
        // 0th row and so on..

        int totalElement = row * col;

        int startEle = row * col - modK;

        List<List<Integer>> ans = new ArrayList();

        int startRow = startEle / col;
        int startCol = startEle % col;

        // System.out.println("startEle: " + startEle + " startRow: " + startRow + " startCol: " + startCol);

        List<Integer> orderWiseNum = new ArrayList();

        for(int i = startRow; i < row; i ++){
            int startColVal = (i == startRow) ? startCol : 0;
            for(int j = startColVal; j < col; j ++){
                orderWiseNum.add(grid[i][j]);
            }
        }

        for(int i = 0; i <= startRow; i ++){
            int endColVal = (i == startRow) ? startCol : col;
            for(int j = 0; j < endColVal; j ++){
                orderWiseNum.add(grid[i][j]);
            }
        }


        for(int i = 0; i < row * col; i += col){
            List<Integer> l1 = new ArrayList();
            for(int j = i; j < i + col; j ++){
                l1.add(orderWiseNum.get(j));
            }
            ans.add(l1);
        }

        System.out.println(orderWiseNum);

        return ans;

    }
}
