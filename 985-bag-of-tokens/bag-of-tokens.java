class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int score = 0;

        int maxScore = score;

        Arrays.sort(tokens);

        for(int i = 0, j = tokens.length - 1; i <= j;){
            if(power >= tokens[i]){
                power -= tokens[i];
                score +=1;
                i++;
                maxScore = Math.max(maxScore, score);
            }
            else if(score >= 1){
                power += tokens[j];
                score -= 1;
                j--;
            }
            else{
                return maxScore;
            }
        }

        return maxScore;
    }
}