class Solution {
    
    public void solution(String s, HashSet<String> set, List<String> ans, String asf){
        
        if(s.length() == 0){
            ans.add(asf.substring(0,asf.length()-1));
            return;
        }
        
        for(int i = 0; i < s.length(); i++){
            String left = s.substring(0, i + 1);
            if(set.contains(left)){
                String right = s.substring(i+1);
                solution(right, set, ans, asf + left + " ");
                
            }
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        List<String> ans = new ArrayList<>();
        
        for(String str : wordDict){
            set.add(str);
        }
        
        solution(s, set, ans, "");
        
        return ans;
    }
}