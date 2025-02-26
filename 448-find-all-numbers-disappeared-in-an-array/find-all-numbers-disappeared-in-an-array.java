class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        int n = nums.length;

        for(int x : nums){
            if(!set.contains(x)){
                set.add(x);
            }
        }
        
        for(int i = 1; i <= n; i++){
            if(!set.contains(i)){
                result.add(i);
            }
        }

        return result;


    }
}