class Solution {
    public boolean canChange(String start, String target) {
        int l = 0, r = 0, len = start.length();

        while(l < len || r < len){

            while(l < len  && start.charAt(l) == '_')l ++;
            while(r < len  && target.charAt(r) == '_')r ++;

            if(l == len || r == len)break;

            if(start.charAt(l) != target.charAt(r)){
                break;
            }

            if(start.charAt(l) == 'L'){
                if(l < r)break;
            }

            if(start.charAt(l) == 'R'){
                if(l > r)break;
            }

            l ++;
            r ++;
        }

        if(l == len && r == len)return true;
        else return false;
    }
}
