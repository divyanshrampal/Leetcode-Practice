class Solution {
    public int myAtoi(String s) {
        
        s = s.trim();
        if(s.length() == 0){
            return 0;
        }
        
        boolean isNegative = false;
        
        long ans = 0;
        
        for(int i = 0; i < s.length(); i++){
            
            char ch = s.charAt(i);
            
            if(i == 0){
                if(ch == '-'){
                    isNegative = true;
                    continue;
                }
                else if(ch == '+'){
                    isNegative = false;
                    continue;
                }
            }
            
            if(ch >= '0' && ch<= '9'){    
                int digit = ch - '0';
                ans = ans*10 + digit;
                
                if(isNegative){
                    long check = -ans;
                    if(check < Integer.MIN_VALUE){
                        return Integer.MIN_VALUE;
                    }
                }
                
                else{
                    if(ans > Integer.MAX_VALUE){
                        return Integer.MAX_VALUE;
                    }
                }
                
            }
            else{
                break;
            }
        }
        
        if(isNegative == true){
            ans = -ans;
        }
        
        return (int)ans;
        
        
    }
}