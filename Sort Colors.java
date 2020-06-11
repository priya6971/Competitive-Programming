/*  Here, we are using one pass algorithm using only constant space.
    Using, three pointers
        p0 - which will take value 0
        p2 - which will take value 2
        p - which will scan an array 
*/


class Solution {
    public void sortColors(int[] nums) {
        int p0 = 0;
        int p2 = nums.length - 1;
        int p = 0;
        
        while(p <= p2){
            if(nums[p] == 2){
                swap(nums,p,p2);
                p2--;
            }
            else if(nums[p] == 0){
                swap(nums,p,p0);
                p++;
                p0++;
            }
            else{
                p++;
            }
        }
    }
    
    public static void swap(int[] nums,int i,int j){
        int temp;
        temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}