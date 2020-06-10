class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int mid = 0;
        int pos = 0;
        
        while(i <= j){
            mid = i + (j-i)/2;
            
            if(nums[mid] == target){
                return mid;
            }
            
            if(nums[mid] < target){
                i = mid+1;
                pos = mid+1;
            }
            
            else{
                j = mid-1;
                pos = mid;
                
            }
        }
        
        return pos;
    }
}