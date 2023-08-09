class Solution {
    public boolean isPalindrome(int x) {
        StringBuilder sb = new StringBuilder();
        if(x < 0){
            sb.append("-");
            x = -1*x;
        }
        
        int save = x;
        int l = 0;
        while(save != 0){
            l++;
            save /= 10;
        }
        
        
        while(l > 0){
            int rem = x / (int)(Math.pow(10, l-1));
            char ch = (char)(rem + '0');
            //System.out.println(ch);
            sb.append(ch);
            x = x % (int)(Math.pow(10, l-1));
            l = l - 1;
        }
        
        //System.out.println(sb);
        for(int i = 0, j = sb.length() - 1; i <= j ; i++, j--){
            if(sb.charAt(i) != sb.charAt(j)){
                return false;
            }
        }
        
        return true;
    }
}