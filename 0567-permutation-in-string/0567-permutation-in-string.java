class Solution {
    
    public static String sortString(String inputString)
    {
        // Converting input string to character array
        char tempArray[] = inputString.toCharArray();
 
        // Sorting temp array using
        Arrays.sort(tempArray);
 
        // Returning new sorted string
        return new String(tempArray);
    }
    
    public boolean checkInclusion(String s1, String s2) {
        
        String pat = sortString(s1);
        int n = s2.length();
        int m = s1.length();
        
        for(int i = 0; i<n-m+1; i++){
            String temp = sortString(s2.substring(i,i+m));
            if(pat.equals(temp)){
                return true;
            }
        }
        
        return false;
        
        
    }
}