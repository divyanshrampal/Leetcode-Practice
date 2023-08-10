class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
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
        
        int l = 0; 
        
        for(int x : ans){
            nums1[l++] = x;
        }
    }
}