class Solution {
    
    public boolean isSafe(int[][] cuboids, int curr, int prev){
        return (cuboids[curr][0] <= cuboids[prev][0] &&
                cuboids[curr][1] <= cuboids[prev][1] &&
                cuboids[curr][2] <= cuboids[prev][2]);
    }
    
    public int solve(int[][] cuboids, int n, int curr, int prev, int[][] dp){
        
        if(curr == n){
            return 0;
        }
        
        if(dp[curr][prev + 1] != -1){
            return dp[curr][prev + 1];
        }
        
        int pick = 0;
        if(prev == -1 || isSafe(cuboids, curr, prev)){
            pick = cuboids[curr][2] + solve(cuboids, n, curr + 1, curr, dp);
        }
        
        int notPick = 0 + solve(cuboids,n,  curr + 1, prev, dp);
        return dp[curr][prev + 1] = Math.max(pick, notPick);
        
    }
    
    public int maxHeight(int[][] cuboids) {
        
        for(int[] dimensions : cuboids){
            Arrays.sort(dimensions);
        }
        
        Arrays.sort(cuboids, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0])
                    return b[0] - a[0];
                if (a[1] != b[1])
                    return b[1] - a[1];
                return b[2] - a[2];
            }
        });
        
        int n = cuboids.length;
        
        int[][] dp = new int[n][n+1];
        
        for(int[] row: dp)
          Arrays.fill(row, -1);
        
        return solve(cuboids, n, 0, -1, dp);
    }
}