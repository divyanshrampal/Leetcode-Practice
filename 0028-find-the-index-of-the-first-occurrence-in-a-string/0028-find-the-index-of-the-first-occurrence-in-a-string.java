class Solution {
    public int strStr(String haystack, String needle) {
     
        if(needle == "")
        {
            return 0;
        }    
        
        int found = -1;
        
        int size = needle.length();
        int last = haystack.length() - size + 1;
        
        for(int i = 0; i < last; i++)
        {
            String temp = haystack.substring(i,i+size); 
            if(temp.equals(needle))
            {
                found = i;
                break;
            }    
        }   
        
        return found;
    }
}