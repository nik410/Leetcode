class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();

      //KMP Algo using longest prefix suffix concept
        int lps[] = new int[n];

        int pre = 0, suff = 1;

        while( suff < n){
            if(s.charAt(pre) == s.charAt(suff)){
                lps[suff] = pre + 1;
                pre++;
                suff++;
            }
            else{
                if( pre == 0){
                    suff++;
                }
                else{
                    pre = lps[pre - 1];
                }
            }
        }

        int patLen = lps[n - 1];

        for(int i = 1; i <= n / 2; i++){
        if(n % i == 0){
            if(patLen == n - i)return true;
        }
        
        }
       
        
        return false;

        

    }
}
