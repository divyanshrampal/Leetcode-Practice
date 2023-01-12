class Solution {
    public int maxCoins(int[] nums) {
        
        // dp[i][j] = dp[i][k-1] + dp[k+1][j] + nums[i-1] * nums[k] * nums[j+1];
        int[][] dp = new int[nums.length][nums.length];
        
        for(int g = 0; g < dp.length; g++){
            for(int i = 0, j = g; j < dp.length; i++, j++){
                int max = Integer.MIN_VALUE;
                for(int k = i; k <=j; k++){
                    int left = (k == i) ? 0 : dp[i][k-1];
                    int right = (k == j) ? 0 : dp[k+1][j];
                    int res = ((i==0)?1:nums[i - 1])*nums[k]*((j==nums.length - 1)?1:nums[j+1]);
                    
                    max = Math.max(max, left + right + res);
                }
                dp[i][j] = max;
            }    
        }
        
        return dp[0][nums.length - 1];
        
    }
}