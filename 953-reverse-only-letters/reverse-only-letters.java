class Solution {

    boolean isAlphabet(char ch){
        return (ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122);
    }

    public String reverseOnlyLetters(String s) {
        StringBuilder sb = new StringBuilder(s);

        for(int i = 0, j = sb.length()-1; i <= j; ){
            char ch1 = sb.charAt(i);
            char ch2 = sb.charAt(j);
            if(!isAlphabet(ch1)){
                i++;
            }
            if(!isAlphabet(ch2)){
                j--;
            }
            if(isAlphabet(ch1) && isAlphabet(ch2)){
                sb.setCharAt(i, ch2);
                sb.setCharAt(j, ch1);
                i++;
                j--;
            }
            
        }
        
        return sb.toString();
    }
}