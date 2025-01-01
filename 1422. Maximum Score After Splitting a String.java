class Solution {
    public int maxScore(String s) {
        int totalZero = 0;
        int totalOne = 0;
        int currZero = 0;
        int currOne = 0;

        for(int i = 0; i < s.length(); i ++){
            if(s.charAt(i) == '0')totalZero ++;
            else{
                totalOne ++;
            }
        }

        int ans = 0;

        for(int i = 0; i < s.length() - 1; i ++){
            if(s.charAt(i) == '0'){
                currZero ++;
                ans = Math.max(ans, currZero + totalOne - currOne);
            }
            else{
                currOne ++;
                ans = Math.max(ans, currZero + totalOne - currOne);
            }
        }

        return ans;
    }
}
