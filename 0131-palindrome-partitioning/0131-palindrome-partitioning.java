class Solution {
    
    private boolean isPalindrom(String str){
        int low = 0;
        int high = str.length() - 1;
        while(low < high){
            if(str.charAt(low) != str.charAt(high)){
                return false;
            }
            low++;
            high--;
        }
        
        return true;
    }
    
    public void getAns(String s, List<String> asf, List<List<String>> ans){
        
        if(s.length() == 0){
            ans.add(new ArrayList<>(asf));
            return;
        }
        
        for(int i = 0; i<s.length(); i++){
            String prefix = s.substring(0,i+1);
            
            if(isPalindrom(prefix)){
                String rem = s.substring(i+1);
                asf.add(prefix);
                getAns(rem,asf,ans);
                asf.remove(asf.size() - 1);
            }
        }
        
        
    }
    
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> asf = new ArrayList<>(); 
        getAns(s,asf,ans);
        return ans;
    }
}