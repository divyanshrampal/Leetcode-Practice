class Solution {

    public int fibWithMemoization(int n, int[] dp){
        if(n == 0){
            return 0;
        }
        if(n ==1){
            return 1;
        }
        if(dp[n] != -1){
            return dp[n];
        }

        int ans = fibWithMemoization(n-1,dp) + fibWithMemoization(n-2,dp);

        dp[n] = ans;
        return dp[n];
    } 

    public int fib(int n) {

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return fibWithMemoization(n, dp);
        
    }
}