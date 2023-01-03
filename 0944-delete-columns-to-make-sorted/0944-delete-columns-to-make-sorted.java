class Solution {
    public int minDeletionSize(String[] strs) {
        
        int count = 0;
        HashSet<Integer> cols = new HashSet<>();
        for(int i = 0; i < strs.length - 1; i++){
            String s1 = strs[i];
            String s2 = strs[i + 1];
            
            for(int j = 0; j < s1.length(); j++){
                
                if(cols.contains(j) == true){
                    continue;
                }
                char ch1 = s1.charAt(j);
                char ch2 = s2.charAt(j);
                if(ch2 < ch1){
                    count++;
                    cols.add(j);
                }
            }
        }
        
        return count;
        
    }
}