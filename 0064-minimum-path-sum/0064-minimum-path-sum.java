class Solution {
    public int minPathSum(int[][] grid) {
        int row= grid.length;
        int col= grid[0].length;
        int [] dp = new int[col];
        
        dp[0]= grid[0][0];
        
        for(int i=1; i<col;i++)
            dp[i]=dp[i-1] + grid[0][i];
        
        for(int i=1; i<row; i++){
            for(int j=0; j<col; j++){
                if(j>0){
                    dp[j]=Math.min(dp[j], dp[j-1])+ grid[i][j];
                }else{
                    dp[j]+=grid[i][j];
                }
            }
        }
        
        return dp[col-1];
        
    }
}