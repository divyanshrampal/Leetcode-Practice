class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = nums[0];

        for(int i = 1; i < nums.length; i++){
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
        }

        int maxLen = dp[0];

        for(int x : dp){
            maxLen = Math.max(x, maxLen);
        }

        return maxLen;
    }
}