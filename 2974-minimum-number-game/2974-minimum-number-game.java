class Solution {
    public int[] numberGame(int[] nums) {
        
        Arrays.sort(nums);
        
        int k = 0;
        int[] arr = new int[nums.length];
        
        for(int i = 0; i < nums.length - 1; i+=2){
            int aliceRemove = nums[i];
            int bobRemove = nums[i + 1];
            arr[k++] = bobRemove;
            arr[k++] = aliceRemove;
        }
        
        
        return arr;
        
    }
}