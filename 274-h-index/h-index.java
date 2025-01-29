class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n+1];

        for(int citation : citations){
            if(citation >= n){
                count[n]++;
            }
            else{
                count[citation]++;
            }
        }

        int papers = 0;
        
        for(int i = n; i >= 0; i--){
            papers += count[i];
            if(papers >= i){
                return i;
            }
        }

        return 0;
    }
}