class Solution {
    public int maxDepth(String s) {
        int ans = 0;
        int count1 = 0;

        for(int i = 0; i < s.length(); i++){
            char c =  s.charAt(i);

            if(c == '(')count1++;
            ans = Math.max(count1, ans);
            if(c == ')')count1--;
        }

        return ans;

    }
}
