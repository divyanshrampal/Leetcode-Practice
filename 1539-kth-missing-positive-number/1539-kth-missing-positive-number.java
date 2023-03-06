class Solution {
    
    public boolean binarySearch(int arr[], int x)
    {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
 
            if (arr[m] == x)
                return true;
 
            if (arr[m] < x)
                l = m + 1;
 
            else
                r = m - 1;
        }

        return false;
    }   
     
    
    public int findKthPositive(int[] arr, int k) {
        
        int n = arr[arr.length - 1];
        int count = 0;
        int ans = -1;
        for(int i = 1; i <= n; i++){
            if(binarySearch(arr, i) == false){
                count++;
                if(count == k){
                    ans = i;
                    break;
                }
            }
        }   
        
        if(ans == -1){
            ans = n + (k - count);
        }
        
        return ans;
        
    }
}