/*
    - Sort the array in descending order
    - We need to maintain a counter variable for city A and city B so that we have exactly N people arrive in           each city
    - When adding to the sum we pick the city with minimum cost(As long as that city is under counter variable)

*/
class Solution {
    int min = Integer.MAX_VALUE;
    int sum = 0;
    public int twoCitySchedCost(int[][] costs) {
        // Greedy Appraoch
        // Used to sort the array in descending order
        Comparator<int[]> comparator = (a,b) -> Math.abs(b[0] - b[1]) - Math.abs(a[0]-a[1]);
        Arrays.sort(costs,comparator);
        
        int N = costs.length/2;
        
        int c1 = 0;     // counter for city A
        int c2 = 0;     // counter for city B
        int ans = 0;
        
        int i = 0;
        
        // Pick the city with the minimum cost
        while(i < 2 * N){
            if((costs[i][0]<costs[i][1] && c1 < N) || c2 == N){
                ans = ans + costs[i++][0];
                c1++;
            }
            else{
                ans = ans + costs[i++][1];
                c2++;
            }
        }
        
        return ans;
        
    }
}