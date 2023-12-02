class Solution {
    
    public HashMap<Character, Integer> getStringMap(String str){
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < str.length(); i++){
            Character ch = str.charAt(i); 
            if(map.containsKey(ch)){
                int val = map.get(ch);
                map.put(ch, val + 1);
            }
            else{
                map.put(ch , 1);    
            }
        }
        
        return map;
    }
    
    public int countCharacters(String[] words, String chars) {
        
        int ans = 0;
        HashMap<Character, Integer> map = getStringMap(chars);
        
        //System.out.println(map);
        
        for(String word : words){
            HashMap<Character, Integer> wordMap = getStringMap(word);
            //System.out.println(wordMap);
            boolean isGood = false;
            for(Character ch : wordMap.keySet()){
                if(map.containsKey(ch) == false || wordMap.get(ch) > map.get(ch) ){
                    isGood = false;
                    break;
                }
                isGood = true;
            }
            
            if(isGood == true){
                ans += word.length();
            }
        }
        
        return ans;
        
        
    }
}