class Solution {
    public int[][] transpose(int[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        int[][] transpose = new int[m][n];
        
        int i = 0;
        int j = 0;
        
        for(i = 0; i < matrix[0].length; i++){
            
            for(j = 0; j < matrix.length; j++){
                
                transpose[i][j] =  matrix[j][i];
                
            }
            
        }
        
        
        return transpose;
        
    }
}