class Solution {
    
    public List<Integer> majorityElement(int[] nums) {
        
        int n = nums.length;
        
        int val1 = nums[0];
        int count1 = 1;
        
        int val2 = nums[0];
        int count2 = 0;
        
        for(int i = 1; i < n; i++){
            if(nums[i] == val1){
                count1++;
            }
            else if(nums[i] == val2){
                count2++;
            }
            else{
                if(count1 == 0){
                    val1 = nums[i];
                    count1 = 1;
                }
                else if(count2 == 0){
                    val2 = nums[i];
                    count2 = 1;
                }
                
                else{
                    count1--;
                    count2--;
                }
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        
        int freq1 = 0;
        int freq2 = 0;
        
        for(int x : nums){
            if(x == val1){
                freq1++;
            }
            else if(x == val2){
                freq2++;
            }
        }
        
        if(freq1 > n/3) ans.add(val1);
        if(freq2 > n/3) ans.add(val2);
        
        return ans;
        
        
    }
}