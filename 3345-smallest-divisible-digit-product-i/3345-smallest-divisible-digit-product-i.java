class Solution {
    
    public boolean isDivisibleDigitProduct(int n, int t){
        
        int product = 1;
        while(n!=0){
            int num = n%10;
            product = product*num;
            n/=10;
        }
        
        //System.out.println(product);
        return (product%t==0);
        
    }
    
    public int smallestNumber(int n, int t) {
        
        for(int i = n; n <= n+10; i++){
            
            if(isDivisibleDigitProduct(i,t)){
                return i;
            }
        }
        
        return 0;
        
    }
}