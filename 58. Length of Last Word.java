class Solution {
    public int lengthOfLastWord(String s) {
        int ans = 0;
        boolean flag = false;
        for(int i = s.length() - 1; i >= 0; i --){
            char c = s.charAt(i);
            if(c == ' '){
                if(flag == false)continue;
                else break;
            }

            else{
                ans++;
                flag = true;
            }
        }

        return ans;
    }
}
