class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1) return nums[0];
        int l=0, r=nums.length-1, mid, num;
        
        while(l < r){
            mid = l+(r-l)/2;
            num = (mid%2 == 0) ? mid+1 : mid-1;
            if(nums[mid]==nums[num]) l = mid+1;
            else r = mid;
        }
        return nums[l];
    }
}