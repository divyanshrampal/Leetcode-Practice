class Solution {

    class Pair{
        int x;
        int y;

        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private void bfs(int row, int col, boolean[][] visited, char[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> que = new LinkedList<>();
        visited[row][col] = true;
        que.add(new Pair(row, col));

        while(que.size() > 0){
            Pair p = que.remove();
            int x = p.x;
            int y = p.y;
            int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};

            for(int i = 0; i < dir.length; i++){
                int dx = x + dir[i][0];
                int dy = y + dir[i][1];

                if(dx >= 0 && dx<m && dy >= 0 && dy < n && grid[dx][dy] == '1' && visited[dx][dy] == false){
                    que.add(new Pair(dx,dy));
                    visited[dx][dy] = true;
                } 
            }

        }
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int islandCount = 0;

        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1' && visited[i][j] == false){
                    bfs(i,j,visited,grid);
                    islandCount++;
                }
            }
        }

        return islandCount;
    }
}