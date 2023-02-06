class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[]  ans = new int[nums.length];
        int i = 0;
        int j = n;
        for(int x = 0; x < nums.length; x++){
            ans[x] = x%2==0 ? nums[i++] : nums[j++];
        }
        return ans;
    }
}