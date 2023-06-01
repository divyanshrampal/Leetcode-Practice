class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        int n = s.length();
         
        for(String str : wordDict){
            set.add(str);
        }
        
        int[] dp = new int[n];
        
        for(int i = 0; i < dp.length; i++){
           for(int j = 0; j <= i; j++){
            String word = s.substring(j, i+1);
            if(set.contains(word)){
                if(j > 0)
                    dp[i] += dp[j-1];
                else
                    dp[i] += 1;
            }
           }
        }
        
        return dp[n-1]>0;
    }
}