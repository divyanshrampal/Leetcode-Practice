class Solution {
    
    public int minDistanceHelper(String s1, String s2, int i, int j, int[][] dp){
        
        if(i == s1.length()){
            return s2.length() - j;
        }
        
        if(j == s2.length()){
            return s1.length() - i;
        }
        
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        
        char first_word1 = s1.charAt(i);
        char first_word2 = s2.charAt(j);
        if(first_word1 == first_word2){
            // match 
            return dp[i][j] = minDistanceHelper(s1, s2, i + 1, j + 1, dp);
            
        }
        
        else{
            int insert = minDistanceHelper(s1, s2, i, j + 1, dp);
            int delete = minDistanceHelper(s1, s2, i + 1, j, dp);
            int replace = minDistanceHelper(s1, s2, i + 1, j + 1, dp);
            
            return dp[i][j] = Math.min(insert, Math.min(delete, replace)) + 1;
        }
    }
    
    
    public int minDistance(String word1, String word2) {
        
        int[][] dp = new int[word1.length()][word2.length()];
        
        
        return minDistanceHelper(word1, word2, 0, 0, dp);
        
        
    }
}