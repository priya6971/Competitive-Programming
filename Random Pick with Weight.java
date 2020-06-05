/*
    Firstly we will find the cumulative sum of the weight array and store it in w_sum array.
    Secondly we call the random function to generate the random number and then apply binary search to see the       range of that random number in pickIndex method. 
    
    Explaination:
    Say we have w[] = {2, 5, 3} then it means that we have to pick an index from {0, 1, 2} based on the w[]           array, meaning
    probability of picking 0 is 2 / (2 + 5 + 3) = 20 percent,
    probability of picking 1 is 5 / (2 + 5 + 3) = 50 percent ,
    probability of picking 2 is 3 / (2 + 5 + 3) = 30 percent.
    Think about this array [0, 0, 1, 1, 1, 1, 1, 2, 2, 2] -> from this array we have to pick a number randomly.
    
    Algorithm :
    
    In order to do it we can generate an array like w_sum[] = {2, 7, 10}, which consists of the cumulative sum of     the w[] array. After this simply generate a random number 10 * Math.random(), which is in the range [0,10).

    random number in [0,1] -> 0
    random number in [2,6] -> 1
    random number in [7,9] -> 2
*/
    
class Solution {
    int[] w_sum;
    public Solution(int[] w) {
        w_sum = new int[w.length];
        
        int sum = 0;
        
        for(int i=0;i<w.length;i++){
            sum = sum + w[i];
            w_sum[i] = sum;
        } 
    }
    
    public int pickIndex() {
        double target = w_sum[w_sum.length-1] * Math.random();
        int res = -1;
        int start = 0;
        int end = w_sum.length - 1;
        
        while(start <= end){
            int mid = start + (end - start)/2;
            if(target < w_sum[mid]){
                res = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */