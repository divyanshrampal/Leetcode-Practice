class Solution {
    private ArrayList<ArrayList<Integer>> adj;
    private Set<Integer> visited;
    
    public int[] dfs(int node, String labels, int[] ans){
        visited.add(node);
        int[] count = new int[26];
        
        for(int nbr : adj.get(node)){
            if(visited.contains(nbr) == false){
                int[] nbrCount = dfs(nbr, labels, ans);
                for(int i = 0; i<26; i++){
                    count[i] += nbrCount[i];
                }
            }
        }
        
        char ch = labels.charAt(node);
        count[ch-'a']++;
        ans[node] = count[ch-'a'];
        
        return count;
        
    }
    
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        
        int ans[] = new int[n];
        
        adj = new ArrayList<ArrayList<Integer> >(n);
 
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<Integer>());
        
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);    
        }
        
        visited = new HashSet<Integer>(n);
        
        dfs(0, labels, ans);
        
        return ans;
        
    }
}