class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        
        List<Integer> ans = new ArrayList<Integer>();
        int k = 0;
        
        for(String str : words){
            
            HashSet<Character> set = new HashSet<>(); 
            
            for(int i = 0; i < str.length(); i++){
                
                Character ch = str.charAt(i);
                set.add(ch);
                
            }
            
            if(set.contains(Character.valueOf(x))){
                ans.add(k);   
            }
            
            k++;
        }
        
        return ans;
    }
}