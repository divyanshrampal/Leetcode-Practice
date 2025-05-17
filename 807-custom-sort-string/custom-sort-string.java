class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> mapForFreq = new HashMap<>();
        String result = "";
        for(Character ch: s.toCharArray()){
            mapForFreq.put(ch, mapForFreq.getOrDefault(ch,0)+1);
        }

        for(Character ch: order.toCharArray()){
            if(mapForFreq.containsKey(ch)){
                int freq= mapForFreq.get(ch);
                while(freq!=0){
                    result += ch;
                    freq--;
                } 
                mapForFreq.remove(ch);
            }
        }
        
        for(Character key:mapForFreq.keySet()){
            int freq = mapForFreq.get(key);
            while(freq!=0){
                    result += key;
                    freq--;
            }
        }

        return result;

    }
}