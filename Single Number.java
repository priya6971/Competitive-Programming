class Solution {
   public int singleNumber(int[] nums) {
    int ans = 0;
    for(int i = 0; i < 32; i++) {
        int sum = 0;
        for(int j = 0; j < nums.length; j++) {
            // counts the number of 1's from 1 to 32 in binary format
            if(((nums[j] >> i) & 1) == 1)
                sum++;
        }
        sum %= 3;
        
        // If sum is multiple of 3 then it's part of group so at that index it's 0 otherwise it should be 1
        if(sum != 0) {
            // to generate the result in decimal format
            ans |= sum << i;
        }
    }
    return ans;
  }
}