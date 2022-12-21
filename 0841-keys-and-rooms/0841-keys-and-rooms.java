class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> que = new LinkedList<>();
        
        for(int i = 0; i<rooms.get(0).size(); i++){
            que.add(rooms.get(0).get(i));
            visited[0] = true;
        }

        while(que.size() > 0){
            int room = que.remove();
            if(visited[room] == false){
            visited[room] = true;
             for(int i = 0; i<rooms.get(room).size(); i++){
                que.add(rooms.get(room).get(i));
              }
            }
        }

        for(boolean check : visited){
            if(check == false){
                return false;
            }
        }

        return true;
    }
}