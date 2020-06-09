class Solution {
    public boolean isSubsequence(String s, String t) {
        int length_t = t.length();
        int length_s = s.length();
        int j = 0;
        int count = 0;
        
        for(int i=0;i<length_t;i++){
            if(j < length_s){
                if(t.charAt(i) == s.charAt(j)){
                    j++;
                    count++;
                }
            }
        }
        if(count == length_s){
            return true;
        }
        
        return false;
    }
}