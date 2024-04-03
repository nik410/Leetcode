class Solution {

    public boolean wordS(char[][] board, String word, int i, int j, int index){
        
        if(index == word.length())return true;

        if(i < 0 || i >=board.length || j < 0 || j >= board[0].length ||  board[i][j] == '1'){
            return false;
        }

        if(word.charAt(index) == board[i][j]){
            char ch = board[i][j];
            board[i][j] = '1';

            boolean down = wordS(board, word, i + 1, j, index + 1);          
           
            boolean right = wordS(board, word, i , j + 1, index + 1);         

            boolean up = wordS(board, word, i - 1, j, index + 1);         

            boolean left = wordS(board, word, i, j - 1, index + 1);          
            
            board[i][j] = ch;           

            return up || left || right || down;
        }
        else{
            return false;
        }
    }

    public boolean exist(char[][] board, String word) {
        StringBuilder stb = new StringBuilder();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                boolean ans = wordS(board, word,i, j, 0);
                if(ans == true)return true;
            }
        }

        return false;

    }
}
