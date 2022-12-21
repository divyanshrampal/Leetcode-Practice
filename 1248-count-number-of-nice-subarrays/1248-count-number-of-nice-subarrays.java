class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int oddCount = 0;
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        for(int i = 0; i<nums.length; i++){
            if(nums[i] %2 != 0){
                oddCount++;
            }
            map.put(oddCount, map.getOrDefault(oddCount, 0) + 1);
            ans += map.getOrDefault(oddCount - k, 0);
        }
        
        return ans;
    }
}