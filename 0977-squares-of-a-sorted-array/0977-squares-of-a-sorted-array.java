class Solution {
    
    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ans = new int[m + n];
        
        int i, j, k = 0;
        
        for(i = 0, j = 0; i < m && j < n;){
            if(nums1[i] <= nums2[j]){
                ans[k++] = nums1[i];
                i++;
            }
            
            else if(nums2[j] < nums1[i]){
                ans[k++] = nums2[j];
                j++;
            }
        }
        
        if(i == m){
            while(j < n)
                ans[k++] = nums2[j++];
        }
        
        if(j == n){
            while(i < m)
                ans[k++] = nums1[i++];
        }
        
        return ans;
    }
    
    public int[] sortedSquares(int[] nums) {
        List<Integer> negative = new ArrayList<>();
        List<Integer> positive = new ArrayList<>();
        
        for(int x : nums){
            if(x < 0){
                negative.add(x);
            }
            else{
                positive.add(x);
            }
        }
        
        Collections.reverse(negative);
        
        for(int i = 0; i < negative.size(); i++){
            int num = negative.get(i);
            num = num*num;
            negative.set(i, num);
        }
        
        for(int i = 0; i < positive.size(); i++){
            int num = positive.get(i);
            num = num*num;
            positive.set(i, num);
        }
        
        System.out.println(positive);
        System.out.println(negative);
        
        int[] arr1 = new int[positive.size()]; 
        
        for (int i = 0; i < positive.size(); i++)
            arr1[i] = positive.get(i);
        
        int[] arr2 = new int[negative.size()];

        for (int i = 0; i < negative.size(); i++)
            arr2[i] = negative.get(i);
        
        return merge(arr1, positive.size(), arr2, negative.size());
    }
}