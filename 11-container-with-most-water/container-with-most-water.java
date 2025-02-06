class Solution {
    public int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0, j = height.length - 1 ; i < j; ){
            
            int length = Math.min(height[i],height[j]);
            int breadth = j - i;

            maxArea = Math.max(maxArea, length*breadth);
            if(height[i] < height[j]){
                i++;
            }
            else{
                j--;
            }
        }

        return maxArea;
    }
}