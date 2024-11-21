class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char mat[][] = new char[m][n];

        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                mat[i][j] = '.';
            }
        }

        for(int i = 0; i < guards.length; i ++){
            mat[guards[i][0]][guards[i][1]] = 'G';
        }

        for(int i = 0; i < walls.length; i ++){
            mat[walls[i][0]][walls[i][1]] = 'W';
        }

        for(int i = 0; i < guards.length; i ++){
            int row = guards[i][0];
            int col = guards[i][1];

            for(int j = row - 1; j >= 0; j --){
                if(mat[j][col] == 'W' || mat[j][col] == 'G')break;
                else{
                    mat[j][col] = 'T';
                }
            }

             for(int j = row + 1; j < m; j ++){
                if(mat[j][col] == 'W' || mat[j][col] == 'G')break;
                else{
                    mat[j][col] = 'T';
                }
            }

             for(int j = col - 1; j >= 0; j --){
                if(mat[row][j] == 'W' || mat[row][j] == 'G')break;
                else{
                    mat[row][j] = 'T';
                }
            }

            for(int j = col + 1; j < n; j ++){
                if(mat[row][j] == 'W' || mat[row][j] == 'G')break;
                else{
                    mat[row][j] = 'T';
                }
            }

        }
        int ans = 0;

        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                if(mat[i][j] != 'G' && mat[i][j] != 'W' && mat[i][j] != 'T')ans ++;
            }
        }

        return ans;
    }
}
