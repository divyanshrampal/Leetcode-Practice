class Solution {
    
    int range;
    Random r;
    HashMap<Integer, Integer> map;

    public Solution(int n, int[] blacklist) {
        range = n - blacklist.length;
        map = new HashMap<>();
        r = new Random();
        HashSet<Integer> invalid = new HashSet<>();
        for(int invalidNumber : blacklist){
            invalid.add(invalidNumber);
        }
        
        int curr = range;
        for(int bl : blacklist){
            if(bl < range){
                while(invalid.contains(curr)){
                    curr++;
                }
                map.put(bl,curr);
                curr++;
            }
        }       
        
    }
    
    public int pick() {
        int ans = r.nextInt(range);
        if(map.containsKey(ans)){
            ans = map.get(ans);
        }
        
        return ans;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */