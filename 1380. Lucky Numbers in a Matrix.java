class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> ans = new ArrayList();
        int r = matrix.length;
        int c = matrix[0].length;
        for(int i = 0; i < r; i ++){
            int minValue = Integer.MAX_VALUE, colIndex = -1;

            for(int j = 0; j < c; j ++){
                if(matrix[i][j] < minValue){
                    minValue = matrix[i][j];
                    colIndex = j;
                }
            }

            int col = colIndex, maxValue = Integer.MIN_VALUE, rowIndex = -1;

            for(int k = 0; k < r; k ++){
                if(maxValue < matrix[k][col]){
                    maxValue = matrix[k][col];
                    rowIndex = k;
                }
            }

            if(rowIndex == i){
                ans.add(matrix[i][col]);
                return ans;
            }

        }

        return ans;
    }
}
