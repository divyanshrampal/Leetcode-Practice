class Solution {
    
    public int getSum(int[] nums){
        int sum = 0;
        
        for(int x : nums){
            sum += x;
        }
        
        return sum;
    }
    
    public int pivotIndex(int[] nums) {
        int lSum = 0;
        int rSum = getSum(nums);
        
        for(int i = 0; i < nums.length; i++){
            rSum = rSum - nums[i];
            if(lSum == rSum){
                return i;
            }
            lSum += nums[i];
        }
        
        return -1;
    }
}