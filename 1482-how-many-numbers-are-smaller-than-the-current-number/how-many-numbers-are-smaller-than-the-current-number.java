class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int[] temp = new int[nums.length];

        for(int k = 0; k < nums.length; k++){
            temp[k] = nums[k];
        }

        Arrays.sort(temp);
        for(int i = 0; i < temp.length; i++){
            if(!map.containsKey(temp[i])){
                map.put(temp[i], i);
            }
        }

        int[] res = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            int x = map.get(nums[i]);

            res[i] = x;
        }

        return res;
    }
}