class Solution {
    
    public int getMaxElement(int[] piles){
        
        int max = Integer.MIN_VALUE;
        for(int x : piles){
            if(x > max){
                max = x;
            }
        }
        
        return max;
    }
    
    public boolean isPossible(int[] piles, int sp, int h){
        int time = 0;
        for(int x : piles){
            time += (int)Math.ceil((x*1.0)/sp);
        }
        
        return (time <= h);
    }
    
    public int minEatingSpeed(int[] piles, int h) {
         
        int low  = 0;
        int high = getMaxElement(piles);
        
        if(h == piles.length){
            return high;
        }
        
        int speed = Integer.MAX_VALUE;
        
        while(low <= high){
            int sp = low + (high - low)/2;
            if(isPossible(piles, sp, h) == true){
                if(sp != 0)
                 speed = sp;
                high = sp - 1;
            }
            else{
                low = sp + 1;
            }
        }
        
        return speed;
    }
}