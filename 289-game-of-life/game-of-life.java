class Solution {

    public boolean isValid(int[][] board,int i, int j){
        int row =  board.length;
        int col =  board[0].length;
        return ((i >= 0 && i < row) && (j >= 0 && j < col));
    }

    public void gameOfLife(int[][] board) {

        int[] x = {0,0,1,1,1,-1,-1,-1};
        int[] y = {1,-1,-1,0,1,-1,0,1};
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                int countLiveZero = 0;

                for(int k = 0; k < 8; k++){
                    int neighbourI = i + x[k];
                    int neighbourJ = j + y[k];

                    if(isValid(board, neighbourI, neighbourJ) && Math.abs(board[neighbourI][neighbourJ]) == 1){
                        countLiveZero++;
                    } 
                }

                if(board[i][j] == 1 && (countLiveZero < 2 || countLiveZero > 3)){
                    board[i][j] = -1;
                }

                if(board[i][j] == 0 && countLiveZero == 3){
                    board[i][j] = 2;
                }
            }
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] >= 1){
                    board[i][j] = 1;
                }
                else{
                    board[i][j] = 0;
                }
            }
        }

    }
}