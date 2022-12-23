class Solution {
    
    public class Pair implements Comparable<Pair>{
        int sp, ep;
        Pair(int sp, int ep){
            this.sp = sp;
            this.ep = ep;
        }
        
        public int compareTo(Pair o){
            return this.sp - o.sp;
        }
    }
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Pair[] pairs = new Pair[n];
        
        int i = 0;
        for(int[] interval : intervals){
            pairs[i++] = new Pair(interval[0], interval[1]);
        }
        Arrays.sort(pairs);
        List<Pair> ans = new ArrayList<>();
        ans.add(pairs[0]);
        for(i = 1; i < n; i++){
            Pair lastInternalInAns = ans.get(ans.size() - 1);
            int inter1sp = lastInternalInAns.sp, inter1ep = lastInternalInAns.ep;
            int inter2sp = pairs[i].sp, inter2ep = pairs[i].ep;
            
            if(inter1ep >= inter2sp){
                lastInternalInAns.ep = Math.max(inter1ep, inter2ep);
            }
            else{
                ans.add(pairs[i]);
            }
        }
        
        int[][] res = new int[ans.size()][2];
        
        i = 0;
        for(Pair pair : ans){
            res[i][0] = pair.sp;
            res[i][1] = pair.ep;
            i++;
        }
        
        return res;
    }
}