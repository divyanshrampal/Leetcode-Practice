class Solution {
    public boolean isAlienSorted(String[] W, String O) {
       
       int A[] = new int[26];
        for (int i = 0; i < O.length(); i++) A[O.charAt(i) - 'a'] = i;
        outer: for (int i = 0; i < W.length - 1; i++)
            for (int j = 0; j < W[i].length(); j++) {
                if (j >= W[i + 1].length()) return false;
                int cur = W[i].charAt(j) - 'a', nxt = W[i + 1].charAt(j) - 'a';
                if (cur != nxt) {
                    if (A[cur] > A[nxt]) return false;
                    else continue outer;
                }
            } 
        return true;
}
}