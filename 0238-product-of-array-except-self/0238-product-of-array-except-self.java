class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int n = nums.length;
        
        int productLeft = 1;
        
        for(int i = 0; i < nums.length; i++){
            productLeft *= nums[i];
            left[i] = productLeft;
        }
        
        int productRight = 1;
        
        for(int i = nums.length - 1; i >= 0; i--){
            productRight *= nums[i];
            right[i] = productRight;
        }
        
        int[] ans = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++){
            
            int leftProduct = (i-1 >= 0)?left[i - 1]:1;
            int rightProduct = (i+1 < n)?right[i + 1]:1;
            
            ans[i] = leftProduct*rightProduct;
        }
        
        return ans;
    }
} 