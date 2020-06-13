class Solution {
    
    List<Integer> res;
    int[] subset;
    
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        subset = new int[nums.length];
        Arrays.fill(subset,-1);
        res = new ArrayList<>();
        helper(nums,0,new ArrayList<>(),1);
        
        return res;   
    }
    
    void helper(int[] nums,int index,List<Integer> curr,int prev){
        // Largest Divisible Subset
        if(curr.size() > res.size()){
            res = new ArrayList<>(curr);
        }
        
        for(int i=index;i<nums.length;i++){
            if(curr.size()>subset[i] && nums[i]%prev == 0){
                subset[i] = curr.size();
                curr.add(nums[i]);
                helper(nums,i+1,curr,nums[i]);
                curr.remove(curr.size()-1);
            }
        } 
    }
}