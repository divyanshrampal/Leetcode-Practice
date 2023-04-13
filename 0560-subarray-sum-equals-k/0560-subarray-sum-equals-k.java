class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(sum, 1);
        int ans = 0;
        
        for(int ele : nums){
            sum += ele;
            int remainingSum = sum - k;
            if(map.containsKey(remainingSum) == true){
                ans+=map.get(remainingSum);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return ans;
    }
}