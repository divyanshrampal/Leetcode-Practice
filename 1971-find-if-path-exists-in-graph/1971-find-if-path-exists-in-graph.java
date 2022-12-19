class Solution {

     class Edge{
        int src,nbr;
        Edge(int src,int nbr){
            this.src = src;
            this.nbr = nbr;
        }
    }

    public boolean solution(ArrayList<Edge>[] graph, int vrtx, int dest, boolean[] visited){

        if(vrtx == dest){
            return true;
        }

        visited[vrtx] = true;
        for(Edge e: graph[vrtx]){
            if(!visited[e.nbr]){
                boolean res = solution(graph, e.nbr, dest, visited);
                if(res == true ) return true;
            }
        }

        return false;

    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        
        ArrayList<Edge>[] graph = new ArrayList[n];

        for(int i = 0 ; i < n ; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < edges.length ; i++){
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            graph[v1].add(new Edge(v1,v2));
            graph[v2].add(new Edge(v2,v1));
        }

        boolean[] visited = new boolean[n];

        return solution(graph, source, destination, visited);

    }
}