class Solution {
    public int minAddToMakeValid(String s) {
        int count1 = 0, count2 = 0, ans = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                count1++;
            }
            else if(s.charAt(i) == ')'){
                count2++;
            }

            if(count2 > count1){
                count1++;
                ans++;
            }
        }
        
        if(count2 != count1)return ans + Math.abs(count1 - count2);
        return ans ;
        
    }
}
