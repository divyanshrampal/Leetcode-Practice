class Solution {
    public boolean isSubsequence(String s, String t) {

        if(t.length() < s.length()){
            return false;
        }

        int k = 0;
        for(int i = 0; i < t.length(); i++){
            if(k == s.length()){
                break;
            }
            char ch1 = t.charAt(i);
            char ch2 = s.charAt(k);
            if(ch1 == ch2){
                k++;
            }  
        }

        return k == s.length();
    }
}