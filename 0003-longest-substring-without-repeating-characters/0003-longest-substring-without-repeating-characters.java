class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int n = s.length();
        int maxLength = 0;
        
        for(int i = 0; i < n; i++){
            HashSet<Character> set = new HashSet<>();
            int len = 0;
            for(int j = i; j < n; j++){
                char ch = s.charAt(j);
                if(set.contains(ch) == true){
                    break;
                }
                else{
                    set.add(ch);
                    len++;
                }
            }
            
            if(len > maxLength){
                maxLength = len;
            }
        }
        
        return maxLength;
    }
}