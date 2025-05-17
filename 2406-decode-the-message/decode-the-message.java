class Solution {
    public String decodeMessage(String key, String message) {
        
        Map<Character, Character> map = new HashMap<>();
        int k = 97;
        for(int i = 0; i < key.length(); i++){
            if(key.charAt(i) == ' '){
                continue;
            }
            else{
                if(map.containsKey(key.charAt(i))){
                    continue;
                }
                else{
                    map.put(key.charAt(i), (char)k++);
                }
            }
        }

        String ans = ""; 

        for(int i = 0; i < message.length(); i++ ){
            char ch = message.charAt(i);

            if(ch == ' '){
                ans += ch;
                continue;
            }

            ans += map.get(ch);
            
        }

        return ans;
    }
}