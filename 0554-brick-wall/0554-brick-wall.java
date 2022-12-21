class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(List<Integer> row : wall){
            int sum = 0;
            for(int i = 0; i < row.size() - 1; i++){
                sum += row.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
                ans = Math.max(ans, map.get(sum));
            }
        }
        
        return wall.size() - ans;
    }
}