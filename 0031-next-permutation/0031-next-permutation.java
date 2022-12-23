class Solution {
    
    public void reverse(int[] nums, int x, int y){
        for(; x<y; x++,y--){
           
           int temp = nums[x];
           nums[x] = nums[y];
           nums[y] = temp;
        }
    }
    
    
    public void nextPermutation(int[] nums) {
        int right = nums.length - 1;
        int idx = -1;
        for(int i = right - 1; i>=0; i--){
            if(nums[i] < nums[i+1]){
                idx = i;
                break;
            }
        }
        
        if(idx == -1){
            reverse(nums, 0, right);
            return;
        }
        
        int idx2 = -1;
        
        for(int j = right; j>=idx; j--){
            if(nums[j] > nums[idx]){
                idx2 = j;
                break;
            }
        }
        
        int temp = nums[idx];
        nums[idx] = nums[idx2];
        nums[idx2] = temp;
        
        reverse(nums, idx + 1, right);
        
    }
}