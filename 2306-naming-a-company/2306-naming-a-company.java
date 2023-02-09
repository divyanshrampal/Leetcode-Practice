class Solution {
    public long distinctNames(String[] ideas) {
        HashSet<String>[] groups = new HashSet[26];
        for (int i = 0; i < 26; ++i) {
            groups[i] = new HashSet<>();
        }
        for (String idea : ideas) {
            groups[idea.charAt(0) - 'a'].add(idea.substring(1));
        }

        long answer = 0;
        for (int i = 0; i < 25; ++i) {
            for (int j = i + 1; j < 26; ++j) {
                
                long mutuals = 0;
                for (String ideaA : groups[i]) {
                    if (groups[j].contains(ideaA)) {
                        mutuals++;
                    }
                }
                answer += 2 * (groups[i].size() - mutuals) * (groups[j].size() - mutuals);
            }
        }
        
        return answer;
    }
}