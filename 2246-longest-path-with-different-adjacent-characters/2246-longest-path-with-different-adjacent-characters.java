class Solution {
    
    private ArrayList<ArrayList<Integer>> adj;
    private int result;
    
    public int DFS(int curr, int parent, String s){
        int longest = 0;
        int secondLongest = 0;
        
        for(int child : adj.get(curr)){
            if(child == parent){
                continue;
            }
            int child_longest_length = DFS(child, curr, s);
            if(s.charAt(child) == s. charAt(curr)){
                continue;
            }
            
            if(child_longest_length > secondLongest){
                secondLongest = child_longest_length;
            }
            
            if(secondLongest > longest){
                int temp = longest;
                longest = secondLongest;
                secondLongest = temp;
                
            }
        }
        
        int best_so_far = Math.max(secondLongest,longest) + 1;
        int only_root = 1;
        int already_found_down = 1 + longest + secondLongest;
        
        result = Collections.max(Arrays.asList(new Integer[]{result, best_so_far, only_root,already_found_down}));
        
        return Math.max(best_so_far, only_root);
        
    }
    
    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        adj = new ArrayList<ArrayList<Integer> >(n);
        result = 0;
        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<Integer>());
        
        for(int i = 1; i<n; i++){
            int u = i;
            int v = parent[i];
            adj.get(u).add(v);
            adj.get(v).add(u);    
        }
        
        DFS(0,-1,s);
        
        return result;
    }
}