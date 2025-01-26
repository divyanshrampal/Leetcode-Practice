class Solution {

    public int helper(int n){
        int sum = 0;
        while(n != 0){
            int rem = n % 10;
            sum += rem*rem;
            n /= 10;
        }

        return sum;
    }

    public boolean isHappy(int n) {
        
        while(n > 9){
            n = helper(n);
        }

        if(n == 1 || n == 7){
            return true;
        }

        return false;
    }
}