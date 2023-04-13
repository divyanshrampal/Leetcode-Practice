class Solution {
    
    public void putZeroes(int[][] visited, int row, int col){
        for(int i = 0; i < visited[0].length; i++){
            visited[row][i] = 0;
        }  
    }

    public void setZeroes(int[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        boolean[] zeroRow = new boolean[n];
        boolean[] zeroCol = new boolean[m];
        
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 0){
                    zeroRow[i] = true;
                    zeroCol[j] = true;
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            if(zeroRow[i] == true){
                int row = i;
                for(int j = 0; j < matrix[0].length; j++){
                   matrix[row][j] = 0;
                } 
            }    
        }
        
        for(int i = 0; i < m; i++){
            if(zeroCol[i] == true){
                int col = i;
                for(int j = 0; j < matrix.length; j++){
                   matrix[j][col] = 0;
                } 
            }    
        }
        
    }
}