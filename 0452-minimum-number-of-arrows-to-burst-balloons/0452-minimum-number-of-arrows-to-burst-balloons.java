class Solution {
    public int findMinArrowShots(int[][] points) {
        
        // sorting array with endpoint
        Arrays.sort(points, (a, b) -> Double.compare(a[1], b[1]));
        
        int arrows = 1;
        int end = points[0][1];
        
        for(int i = 1; i<points.length; i++){
            int sp = points[i][0];
            int ep = points[i][1];
            
            if(sp > end){
                arrows++;
                end = ep;
            }
            
        }
        
        return arrows;
    }
}