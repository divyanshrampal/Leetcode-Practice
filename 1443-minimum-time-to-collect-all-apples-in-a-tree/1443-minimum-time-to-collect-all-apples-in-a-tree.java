class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        var graph = buildGraph(edges, n);
        boolean[] isVisited = new boolean[n];
        return helper(graph, hasApple, isVisited, 0);
    }

    private int helper( ArrayList<ArrayList<Integer>> graph, List<Boolean> hasApple, boolean[] isVisited, int index){
        if(isVisited[index]) return 0;
        isVisited[index] = true;
        int edges = 0;
        for(int adjacent : graph.get(index)){
            if(!isVisited[adjacent]){
                edges += helper(graph, hasApple, isVisited, adjacent);
            }
        }

        if(index == 0) return edges;

        if(edges > 0 || hasApple.get(index)) edges += 2;
        return edges;
    }

    private ArrayList<ArrayList<Integer>> buildGraph(int[][] edges, int n){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(n);
        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }
}