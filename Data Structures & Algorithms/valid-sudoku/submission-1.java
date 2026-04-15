class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int[] row = new int[9];   
        int[] col = new int[9];   
        int[] squares = new int[9];   

        for(int r=0;r<9;r++){
            for(int c=0;c<9;c++){
                if(board[r][c] == '.') continue;

                int val = board[r][c] - '1';

                if((row[r]&(1<<val)) > 0 || 
                (col[c]&(1<<val)) > 0 || 
                (squares[(r/3)*3 + (c/3)] & (1<<val)) > 0){
                    return false;
                }
                row[r] |= (1<<val);
                col[c] |= (1<<val);
                squares[(r/3)*3 + (c/3)] |= (1<<val);
            }
        }
        return true;
    }
}
