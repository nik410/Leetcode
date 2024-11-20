class Solution {
    public int takeCharacters(String s, int k) {
        int l = 0, r = 0;

        int aCount = 0;
        int bCount = 0;
        int cCount = 0;

        for(int i = 0; i < s.length(); i ++){
            if(s.charAt(i) == 'a')aCount ++;
            if(s.charAt(i) == 'b')bCount ++;
            if(s.charAt(i) == 'c')cCount ++;
        }


        int ans = s.length() + 3;

        while(r < s.length()){
            if(s.charAt(r) == 'a')aCount --;
            if(s.charAt(r) == 'b')bCount --;
            if(s.charAt(r) == 'c')cCount --;

            while(l <= r &&  (aCount < k || bCount < k || cCount < k)){
                
                if(s.charAt(l) == 'a')aCount ++;
                if(s.charAt(l) == 'b')bCount ++;
                if(s.charAt(l) == 'c')cCount ++;
                l ++;
            }

            if(aCount >= k && bCount >= k && cCount >= k){
                ans = Math.min(ans, s.length() - (r - l + 1));
            }            

            r ++;
        }

        if(ans == s.length() + 3)return -1;

        return ans;

    }
}
