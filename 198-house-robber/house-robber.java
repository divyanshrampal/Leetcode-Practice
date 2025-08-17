class Solution {

    public int robWithMemoization(int[] nums, int i, int[] dp){

        if(i >= nums.length){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }

        // include
        int ans1 = nums[i] + robWithMemoization(nums, i + 2, dp);

        // exclude
        int ans2 = robWithMemoization(nums, i + 1, dp);

        dp[i] = Math.max(ans1, ans2);

        return dp[i];
    }

    public int robWithRecursion(int[] nums, int i){

        if(i >= nums.length){
            return 0;
        }

        // include
        int ans1 = nums[i] + robWithRecursion(nums, i + 2);

        // exclude
        int ans2 = robWithRecursion(nums, i + 1);

        return Math.max(ans1, ans2);

    }

    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);

        dp[nums.length] = 0;

        for(int i = nums.length -1; i >= 0; i--){
            int include = nums[i];
            if(i+2 <= nums.length)
                include = include + dp[i+2];
            int exclude = dp[i+1];
            dp[i] = Math.max( include, exclude);

        }

        return dp[0];
        
    }
}