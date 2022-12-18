class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        int[] buffer = new int[nums.length + 1];
        
        for(int i = 0; i < nums.length; i++){
            buffer[nums[i]] += 1;
        }
        
        List<Integer> ans = new ArrayList<>();
        for(int i = 1; i< buffer.length; i++){
            if(buffer[i] == 2){
                ans.add(i);
            }
        }
        
        return ans;
        
    }
}