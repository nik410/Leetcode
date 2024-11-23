class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int row = box.length;
        int col = box[0].length;

        char ans[][] = new char[col][row];

       

        // System.out.println(row + " " +  col);

        // for(int i = 0; i < col; i ++){
        //     for(int j = 0; j < row; j ++){
        //         System.out.print(ans[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        for(int i = 0; i < row; i ++){
            
            int emp = col - 1;
            int curr = col - 1;

            while(curr >= 0){
                char ch = box[i][curr];

                if(ch == '.'){                    
                    curr --;
                }
                else if(ch =='*'){                                                        
                    curr --;
                    emp = curr;
                }
                else{
                    box[i][curr] ='.';                    
                    box[i][emp] = '#';                    
                    curr --;
                    emp --;
                }
            }
            
        }

         for(int i = col - 1; i >= 0; i --){
            for(int j = 0; j < row; j ++){
                ans[i][j] = box[row - j - 1][i];
            }
        }

        return ans;
    }
}

