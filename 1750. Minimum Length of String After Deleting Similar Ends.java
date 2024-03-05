class Solution {
    public int minimumLength(String s) {
        int l = 0, r = s.length() - 1;
        int count = 0;
        while(l < r && s.charAt(l) ==  s.charAt(r)){

            char c = s.charAt(l);

            while(l <= r && s.charAt(l) == c){                    
                    l++;
                }
                
            while( l <= r && s.charAt(r) == c){                    
                    r--;
                }             
                       
        }

        if(l > r)return 0;
        else return r - l + 1;
    }
}
