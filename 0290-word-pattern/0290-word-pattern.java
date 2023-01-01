class Solution {
    public boolean wordPattern(String pattern, String s) {
         
        Map<Character, String> map = new HashMap<>();
        Set<String> used = new HashSet<>();
        String words[] = s.split(" ");
        if(words.length != pattern.length()){
            return false;
        }
        for(int i = 0; i<pattern.length(); i++){
            char ch = pattern.charAt(i);
            String str = words[i];
            if(map.containsKey(ch) == false){
                if(used.contains(str) == true){
                    return false;
                }
                else{
                    map.put(ch, str);
                    used.add(str);
                }    
            }
            else{
                String mappedWith = map.get(ch);
                if(mappedWith.equals(str) == false){
                    return false;
                }
            }     
        }
        return true;
    }
}