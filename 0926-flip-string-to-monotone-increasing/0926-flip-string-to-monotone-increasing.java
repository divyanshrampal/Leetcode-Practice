class Solution {
    public int minFlipsMonoIncr(String s) {
        int ones = 0, flips = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                flips++;
            } else {
                ones++;
            }
            flips = Math.min(flips, ones);
        }
        return flips;
    }
}