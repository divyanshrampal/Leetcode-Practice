class Solution {
    
    public int getAns(int i, int j, int[] arr, int[][] dp){
        if(i > j){
            return 0;
        }
        
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        
        int min = Integer.MAX_VALUE;
        for(int index = i; index<=j; index++){
            int cost = arr[j+1] - arr[i-1] + getAns(i, index -1, arr, dp) + getAns(index + 1, j, arr, dp);
            min = Math.min(cost, min);
        }
        
        return dp[i][j] = min;
        
    }
    public int minCost(int n, int[] cuts) {
        int[] arr = new int[cuts.length + 2];
        
        arr[0] = 0;
        
        
        for(int i = 1; i<=cuts.length; i++){
            arr[i] = cuts[i-1];
        }
        
        arr[arr.length -1] = n;
        
        Arrays.sort(arr);
        
        int[][] dp = new int[arr.length][arr.length];
        
        return getAns(1,cuts.length, arr, dp);
    }
}