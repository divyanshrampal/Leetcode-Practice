class Solution {
    
    public boolean isCapital(char ch){
        
        return (ch >= 65 && ch <= 90);
    }
    
    public boolean detectCapitalUse(String word) {
        
        int index = -1;
        int capitalCount = 0;
        for(int i = 0; i<word.length(); i++){
             char ch = word.charAt(i);
             if(isCapital(ch) == true){
                 index = i;
                 capitalCount++;
             }
        }
        
        if(index == -1){
            return true;
        }
        
        else if(index == 0 && capitalCount == 1){
            return true;
        }
        
        else if(index == word.length() - 1 && capitalCount == word.length()){
            return true;
        }
        
        else{
            return false;
        }
        
        
    }
}