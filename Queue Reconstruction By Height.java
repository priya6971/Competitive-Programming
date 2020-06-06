class Solution {
    public int[][] reconstructQueue(int[][] people) {
        
        Arrays.sort(people,new Comparator<int[]>(){
            public int compare(int a[],int b[]){
                // if height is same sort the array according to k value 
                // smaller k value comes first
                if(b[0] == a[0]) return a[1] - b[1];
                // sort according to the height
                // higher height will come first
                return b[0] - a[0];
            }
        });
        
        List<int[]> res = new ArrayList<>();
        
        for(int[] p:people){
            res.add(p[1],p);
        }
        
        int n = people.length;
        return res.toArray(new int[n][2]);
        
    }
}