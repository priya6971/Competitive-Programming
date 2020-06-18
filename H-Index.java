class Solution {
    public int hIndex(int[] citations) {
        int i = 0;
        int j = citations.length - 1;
        int N = citations.length;
        
        while(i <= j){
            int mid = i + (j-i)/2;
            
            if(citations[mid] == N - mid){
                return N-mid;
            }
            else if(citations[mid] < N - mid){
                i = mid + 1;
            }
            else{
                j = mid - 1;
            }
        }
        
        return N - i;
    }
}