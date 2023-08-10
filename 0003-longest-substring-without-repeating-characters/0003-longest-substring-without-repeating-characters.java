class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int n = s.length();
        if(n == 0){
            return 0;
        }
        int maxLength = 0;
        HashSet<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        int len = 1;
        
        for(int i = 1; i < n;){
            
            if(set.contains(s.charAt(i)) == false){
                set.add(s.charAt(i));
                i++;
                len++;
                if (len > maxLength) {
                  maxLength = len;
                }
            }
            else{
              set.clear();
              i = i - len + 1;
              len = 0;
            }
        }
        
        return Math.max(maxLength, len);
    }
}