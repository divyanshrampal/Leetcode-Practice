class Solution {
    
    public int getAns(int[] arr,boolean[] visited, Map<Integer, List<Integer>> map){
        int n = arr.length;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
        int steps = 0;
        
        while(q.size() > 0){
            int size = q.size();
            while(size-- != 0){
                int curr = q.remove();
                
                int left = curr - 1;
                int right = curr + 1;
                
                if(curr == n - 1){
                    return steps;
                }
                
                if(left >= 0 && visited[left] == false){
                    q.add(left);
                    visited[left] = true;
                }
                
                if(right <= n - 1 && visited[right] == false){
                    q.add(right);
                    visited[right] = true;
                }
                
                
                if(map.containsKey(arr[curr])){
                    List<Integer> li = map.get(arr[curr]);
                    for(int y : li){
                        if(visited[y] == false){
                            q.add(y);
                            visited[y] = true;
                        }
                    }
                } 
                map.remove(arr[curr]);
                
            }
            
            steps++;
        }
        
        return -1;
        
    }
    
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < arr.length; i++){
            int x = arr[i];
            if(map.containsKey(x)){
                List<Integer> li = map.get(x);
                li.add(i);
                map.put(x, li);
            }
            else{
                List<Integer> indices = new ArrayList<>();
                indices.add(i);
                map.put(x, indices);
            }
        }
        
        boolean[] visited = new boolean[arr.length];
        
        return getAns(arr, visited, map);
        
    }
}

