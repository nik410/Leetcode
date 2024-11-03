class Solution {
    public boolean rotateString(String s, String goal) {
        int sLen = s.length();
        for(int i = 0; i < sLen * 2; i ++){

            int j = i;
            int k = 0;

            while(k < goal.length() &&j <  i + sLen && s.charAt(j % sLen) == goal.charAt(k)){
                j ++;
                k ++;
            }

            if(k == sLen)return true;
        }

        return false;
    }
}
