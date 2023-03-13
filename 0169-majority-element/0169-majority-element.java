class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int x : nums){
            if(map.containsKey(x)){
                int freq = map.get(x) + 1;
                map.put(x, freq);
            }
            else{
                map.put(x, 1);
            }
        }
      
        
        int n = nums.length;
        int ans = 0;
        
        for(int key : map.keySet()){
            
            if(map.get(key) > n/2){
                ans = key;
                break;
            }
        }
        
        return ans;
        
    }
}