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
        
        HashSet<Integer> set  = new HashSet<>();
        while(true){
            n = helper(n);
            if(n == 1){
                return true;
            }
            if(set.contains(n)){
                break;
            }
            set.add(n);
        }
        
        return false;
    }
}