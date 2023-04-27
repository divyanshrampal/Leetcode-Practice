class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;
        
        boolean up = true;
        int[] ans = new int[n*m];
        int k = 0;
        
        int row = 0;
        int col = 0;
        
        while(row < m && col < n){
            if(up == true){
                while(row > 0 && col < n-1){
                    ans[k++] = mat[row][col];
                    row--;
                    col++;
                }
                ans[k++] = mat[row][col];
                if(col == n - 1){
                    row++;
                }
                else{
                    col++;
                }
            }
            else{
                while( col > 0 && row < m-1){
                    ans[k++] = mat[row][col];
                    row++;
                    col--;
                }
                ans[k++] = mat[row][col];
                if(row == m - 1){
                    col++;
                }
                else{
                    row++;
                }
            }
            up = !up;
        }
        
        return ans;

    }
}