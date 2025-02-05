class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int count = 0;
        char c1 = ' ', c2 = ' ', c3 = ' ', c4 = ' ';
        for(int i = 0; i < s1.length(); i ++){
            if(s1.charAt(i) != s2.charAt(i)){
                count ++;
                if(count == 1){
                    c1 = s1.charAt(i);
                    c2 = s2.charAt(i);
                }
                if(count == 2){
                    c3 = s1.charAt(i);
                     c4 = s2.charAt(i);
                }
            }
            if(count > 2)return false;
        }
        if((count == 2 || count == 0) && (c2 == c3) && c4 == c1)
        return true;
        else{
            return false;
        }
    }
}
