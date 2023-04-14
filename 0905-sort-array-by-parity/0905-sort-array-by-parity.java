class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int even = 0;
        int odd = nums.length - 1;
        int[] ans = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 0){
                ans[even++] = nums[i];
            }
            else{
                ans[odd--] = nums[i];
            }
        }
        
        return ans;
    }
}