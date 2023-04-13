class Solution {
    
    public void setZeroes(int[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        boolean isRowZero = false;
        boolean isColZero = false;
        
        
        for(int i = 0; i < n; i++){
            if(matrix[i][0] == 0){
                isColZero = true;
            }
        }
        
        for(int j = 0; j < m; j++){
            if(matrix[0][j] == 0){
                isRowZero = true;
            }
        }
        
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
               if(matrix[i][j] == 0){
                  matrix[0][j] = 0;
                  matrix[i][0] = 0;
               } 
            }    
        }
        
        
        for(int col = 1; col < m; col++){
            if(matrix[0][col] == 0){
               for(int row = 0; row < n; row++){
                   matrix[row][col] = 0;
                }  
            }
        }
        
        for(int row = 1; row < n; row++){
            if(matrix[row][0] == 0){
               for(int col = 0; col < m; col++){
                   matrix[row][col] = 0;
                }  
            }
        }
        
        if(isRowZero == true){
            for(int i = 0; i < m; i++){
                matrix[0][i] = 0;
            }
        }
        
        if(isColZero == true){
            for(int i = 0; i < n; i++){
                matrix[i][0] = 0;
            }
        }
        
    }
}