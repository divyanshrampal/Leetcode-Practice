class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        int minimumNumberOfRabbits = 0;

        for(int x : answers){
            if(map.containsKey(x+1)){
                int val = map.get(x+1);
                val += 1;
                map.put(x+1, val);
            }
            else{
                map.put(x+1, 1);
            }
        }

        for (Integer key : map.keySet()) {
            int val = map.get(key);
            int q = val/key;
            int r = val%key;
            minimumNumberOfRabbits += q*key;
            if(r > 0){
                minimumNumberOfRabbits += key;
            }
        }

        return minimumNumberOfRabbits;
    }
}