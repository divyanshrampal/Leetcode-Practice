class Solution {
    public int kthFactor(int n, int k) {
        List<Integer> factors = new ArrayList<>();
        factors.add(1);
        for(int i = 2; i <= n/2; i++){
            if(n % i == 0){
                factors.add(i);
            }
        }

        factors.add(n);

        if(k <= factors.size()){
            return factors.get(k - 1);
        }

        return -1;
    }
}