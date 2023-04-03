class Solution {
    public int numRescueBoats(int[] people, int limit) {
        
        Arrays.sort(people);
        
        int boat = 0;
        int high = people.length - 1;
        int low = 0;
        
        while(low <= high){
            int rem = limit - people[high];
            if(rem >= people[low]){
                low++;
            }
            high--;
            boat++;
        }
        
        return boat;
        
    }
}