
class Solution {
    
    public  int[] lpsFunc(String s){
        int n = s.length();
        int lps[] = new int[n];
        int pre = 0, suff = 1;
        while(suff < n){
            if(s.charAt(pre) == s.charAt(suff)){
                lps[suff] = pre + 1;
                pre++;
                suff++;
            }
            else{
                if(pre == 0){
                    lps[suff] = 0;
                    suff++;
                }
                else{
                    pre = lps[pre - 1];
                }
            }
        }
        
        return lps;       
    }
    
    
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {


      //Good Question I am using KMP algo crux to solve this 

      
        int lpsA[] = lpsFunc(a);
        int lpsB[] = lpsFunc(b);
        ArrayList<Integer> aMatch = new ArrayList();
        
        int l = 0, r = 0; 
        
        while(l < s.length()){
            if(s.charAt(l) == a.charAt(r)){
                l++;
                r++;
            }
            else{
                if(r == 0){
                    l++;
                }
                else{
                    r = lpsA[r - 1];
                }
            }
            if(r == a.length()){
                aMatch.add(l - r);
                r = lpsA[r - 1];
            }
        }        
        
        
        
        ArrayList<Integer> bMatch = new ArrayList();
        l = 0;
        r = 0; 
        
        while(l < s.length()){
            if(s.charAt(l) == b.charAt(r)){
                l++;
                r++;
            }
            else{
                if(r == 0){
                    l++;
                }
                else{
                    r = lpsB[r - 1];
                }
            }
            if(r == b.length()){
                bMatch.add(l - r);
                r = lpsB[r - 1];
            }
        }
        ArrayList<Integer> ans = new ArrayList();
        int prev = -1;
        for(int i = 0; i < aMatch.size(); i++){
            int ind = aMatch.get(i);
            
            for(int j = 0; j < bMatch.size(); j++){
                int ind1 = bMatch.get(j);
                
                if(Math.abs(ind - ind1) <= k && prev != ind){
                    ans.add(ind);
                    prev = ind;
                }
                else if(prev == ind)break;
            }
           
        }
        
        
        
        
        return ans;
        
    }
}
