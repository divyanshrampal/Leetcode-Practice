class Solution {
    
    public void putZeroes(int[][] visited, int row, int col){
        for(int i = 0; i < visited[0].length; i++){
            visited[row][i] = 0;
        }
        
        for(int k = 0; k < visited.length; k++){
            
            visited[k][col] = 0;
        }   
    }

    public void setZeroes(int[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        int[][] visited = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                visited[i][j] = -1;
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 0){
                    putZeroes(visited, i , j);
                }
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        
    }
}