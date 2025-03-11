class Solution {

    public boolean containsAllChar(int arr[]){
        if(arr[0] > 0 && arr[1] > 0 && arr[2] > 0){
               return true;
        }
        return false;
    }

    public int numberOfSubstrings(String s) {
        int ans = 0;
        int len = s.length();
        int l = 0, r = 0;
        int arr[] = new int[3];
        while(r < len){
            char c = s.charAt(r);
            if(c =='a' || c == 'b' || c == 'c'){
                arr[c - 'a'] ++;
            }

           while(containsAllChar(arr)){
                ans += len - r ;
                char c1 = s.charAt(l);
                if(c1 =='a' || c1 == 'b' || c1 == 'c'){
                     arr[c1 - 'a'] --;
                }
                l ++;
            }
          
          r ++;
        }

        return ans;
    }
}
